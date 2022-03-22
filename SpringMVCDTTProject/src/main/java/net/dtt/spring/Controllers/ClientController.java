package net.dtt.spring.Controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
import net.dtt.spring.Models.ViewModels.AddToCardRequestModel;
import net.dtt.spring.Models.ViewModels.CommentViewModel;
import net.dtt.spring.Models.ViewModels.ResponseModel;
import net.dtt.spring.Models.ViewModels.SendCommentRequestModel;
import net.dtt.spring.Service.IService;

@Controller
public class ClientController {
	@Autowired
	private IService _service;
	
	 @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	 public String HomePage(Model model) {
		 var ListCategory = _service.getAllCategory();
		 var listProductRecomment = _service.GetRecommentProduct(8);
		 //var ListBestSellerProduct = _dataAccess.GetAllProduct();
		 
		 model.addAttribute("list_category", ListCategory);
		 model.addAttribute("list_product_recomment", listProductRecomment);
		 //model.addAttribute("list_bestSeller_product", ListBestSellerProduct);
		 
	     return "/Client/HomePage";
	 }
	 
	 @RequestMapping(value = "/Detail-Product/{ProductId}", method = RequestMethod.GET)
	 public String DetailProductPage(Model model, @PathVariable(value="ProductId") int productId) {
		 var productDetail = _service.GetDetailproduct(productId);
		 
		 model.addAttribute("product_detail", productDetail);
		 model.addAttribute("product_id", productId);
		 
		 return "/Client/DetailProduct";
	 }
	 
	 @RequestMapping(value = "/All-Products", method = RequestMethod.GET)
	 public String AllProductPage(Model model, @RequestParam(value="offset") int offset, @RequestParam(value="cateid", required = false) String cateId) {
		 
		 //split page	 
		 int total = 10;
		 int current_page = offset;
		 
		 if(offset == 1) {}
		 else {
			 offset = (offset-1) * total + 1;
		 }
		 
		 //filter
		 String[] splitIdCateFilter = null;
		 if(cateId != null) {
			 splitIdCateFilter = cateId.split("-");
		 }
		 var AllProducts = _service.GetAllProduct(offset, splitIdCateFilter);
		 var AllCategory = _service.getAllCategory();
		 
		 var CountProducts = AllProducts.size();
		 double CountProductsCalculator = CountProducts / total;
		 CountProducts = (int) (CountProductsCalculator + 2);
		 
		 model.addAttribute("all_product", AllProducts);
		 model.addAttribute("count_product", CountProducts);
		 model.addAttribute("current_page", current_page);
		 model.addAttribute("all_category", AllCategory);
		 model.addAttribute("current_cateid", cateId);
		 
		 return "/Client/AllProducts";
	 }
	 
	 @RequestMapping(value = "/viewCommentJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List<CommentViewModel> getCommentJson(@RequestParam(value="prodId") int prodId) {
		 var listComment = new ArrayList<CommentViewModel>();
		 var cmtService = _service.GetCommentOfProduct(prodId);
		 
		 for (CommentProductDaoModel cmt : cmtService) {
			listComment.add(new CommentViewModel(cmt.getId(), cmt.getContent(), cmt.getTime(), cmt.getStart(), cmt.getCustomer().getName(), "https://ava"));
		 }
		 
	     return listComment;
	 }
	 
	 @RequestMapping(value = "/sendComment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseModel sendComment(@RequestBody SendCommentRequestModel cmt) {
		 
		 if(_service.sentComment(cmt.getContent(), Integer.parseInt(cmt.getStart()), Integer.parseInt(cmt.getProdId()), 1)) {
			 return new ResponseModel(200, "Success", true);
		 }
		 else {
			 return new ResponseModel(400, "Failed", false);
		 }
	 }
	 
	 @RequestMapping(value = "/addToCartJson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseModel addToCard(@RequestBody AddToCardRequestModel cart, HttpServletRequest request) {
		 List<AddToCardRequestModel> cartInfo = (List<AddToCardRequestModel>) request.getSession().getAttribute("cart");
		 boolean isDefined = false;
		 
		 if(cartInfo != null && cartInfo.size() > 0) {
			 
			 for(int i = 0; i < cartInfo.size(); i++) {
				 System.out.println("=========" + cart.getProductId() + " VS " + cartInfo.get(i).getProductId());
				 if(cartInfo.get(i).getProductId() == cart.getProductId()) {
					 isDefined = true;
					if (cartInfo.get(i).getAction() == 0) {
						cartInfo.get(i).setNumber(cartInfo.get(i).getNumber() + 1 );
						System.out.println("================== 1 + || " + cartInfo.get(i).getNumber());
					}
					else {
						cartInfo.get(i).setNumber(cartInfo.get(i).getNumber() - 1 );
						if(cartInfo.get(i).getNumber() == 0) {
							cartInfo.remove(cartInfo.get(i));
							System.out.println("================== 2");
						}
					}
				 }
			 }
			 
			 if(!isDefined) {
				 System.out.println("============== 3" );
				 cartInfo.add(cart);
			 }
		 }
		 else {
			 System.out.println("================== 4");
			 cartInfo = new ArrayList<AddToCardRequestModel>();
			 cartInfo.add(cart);
		 }
		 
		 request.getSession().setAttribute("cart", cartInfo);
		 
		 return new ResponseModel(200, "Success", true);
	 }
	 
	 @RequestMapping(value = "/cart", method = RequestMethod.GET)
	 public String CartPage(Model model, HttpSession session) {
		 List<AddToCardRequestModel> cartInfo = (List<AddToCardRequestModel>)session.getAttribute("cart");
		 
		 model.addAttribute("list_cart", cartInfo);
		 
		 return "/Client/Cart";
	 }
}




















