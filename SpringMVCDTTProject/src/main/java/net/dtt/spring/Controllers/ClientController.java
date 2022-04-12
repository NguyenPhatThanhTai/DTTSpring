package net.dtt.spring.Controllers;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
import net.dtt.spring.Models.ViewModels.AddToCardRequestModel;
import net.dtt.spring.Models.ViewModels.CheckOutCardRequestModel;
import net.dtt.spring.Models.ViewModels.CommentViewModel;
import net.dtt.spring.Models.ViewModels.LoginRequestModel;
import net.dtt.spring.Models.ViewModels.RegisterRequestModel;
import net.dtt.spring.Models.ViewModels.ResponseModel;
import net.dtt.spring.Models.ViewModels.SendCommentRequestModel;
import net.dtt.spring.Service.IService;
import net.dtt.spring.ServiceDTO.MailDTO;
import net.dtt.spring.entity.Test;

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
		 
//		 MailDTO mail = new MailDTO();
//		 mail.sendMail("nguyenphatthanhtai@gmail.com", "Test", "<img src=\"https://toigingiuvedep.vn/wp-content/uploads/2021/06/hinh-anh-suy-tu-1.jpg\"  width=\"500\" height=\"600\">");
		 
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
	 public @ResponseBody ResponseModel addToCard(@RequestBody AddToCardRequestModel cart, HttpServletRequest request, HttpServletResponse response, @CookieValue(name ="cart", required=false) String cartCookie) {
		 List<AddToCardRequestModel> cartInfo = new Gson().fromJson(cartCookie, new TypeToken<List<AddToCardRequestModel>>(){}.getType());
		 boolean isDefined = false;
		 
		 if(cartInfo != null && cartInfo.size() > 0) {
			 
			 for(int i = 0; i < cartInfo.size(); i++) {
				 if(cartInfo.get(i).getProductId() == cart.getProductId()) {
					 isDefined = true;
					if (cart.getAction() == 0) {
						cartInfo.get(i).setNumber(cartInfo.get(i).getNumber() + 1 );
					}
					else {
						cartInfo.get(i).setNumber(cartInfo.get(i).getNumber() - 1 );
						if(cartInfo.get(i).getNumber() == 0) {
							cartInfo.remove(cartInfo.get(i));
						}
					}
				 }
			 }
			 
			 if(!isDefined) {
				 cartInfo.add(cart);
			 }
		 }
		 else {
			 cartInfo = new ArrayList<AddToCardRequestModel>();
			 cartInfo.add(cart);
		 }
		 
		 //request.getSession().setAttribute("cart", cartInfo);
		 
		 //add to cookie
		 String cartJson = new Gson().toJson(cartInfo);
		 response.addCookie(new Cookie("cart", cartJson));
		 
		 return new ResponseModel(200, "Success", true);
	 }
	 
	 @RequestMapping(value = "/cart", method = RequestMethod.GET)
	 public String CartPage(Model model, HttpSession session, @CookieValue(name ="cart", required=false) String cartCookie) {
		 List<AddToCardRequestModel> cartInfo = new Gson().fromJson(cartCookie, new TypeToken<List<AddToCardRequestModel>>(){}.getType());
		 
		 //<AddToCardRequestModel> cartInfo = (List<AddToCardRequestModel>)session.getAttribute("cart");
		 
		 model.addAttribute("list_cart", cartInfo);
		 
		 return "/Client/Cart";
	 }
	 
	 @RequestMapping(value = "/order", method = RequestMethod.GET)
	 public String OrderPage(Model model, HttpServletRequest request, @CookieValue(name ="cart", required=false) String cartCookie) {
		 var userInfo = request.getSession().getAttribute("User");
		 if(userInfo == null) {
			 return "redirect:/Login";
		 }
		 
		 List<AddToCardRequestModel> cartInfo = new Gson().fromJson(cartCookie, new TypeToken<List<AddToCardRequestModel>>(){}.getType());
		 
		 if(cartInfo != null) {
			 var totalMoney = 0;
			 
			 for (AddToCardRequestModel item : cartInfo) {
				 totalMoney += item.getPrice() * item.getNumber();
			 }
			 
			 model.addAttribute("total_money", totalMoney);
		 }
		 
		 model.addAttribute("list_cart", cartInfo);
		 model.addAttribute("user", userInfo);
		 
		 return "/Client/order";
	 }
	 
	 @RequestMapping(value = "/Login", method = RequestMethod.GET)
	 public String LoginPageGet(Model model, HttpServletRequest request) {
		 var userInfo = request.getSession().getAttribute("User");
		 if(userInfo != null) {
			 request.getSession().removeAttribute("User");
		 }
		 
		 return "/Client/Login";
	 }
	 
	 @RequestMapping(value = "/Login", method = RequestMethod.POST)
	 public String LoginPagePost(Model model, HttpServletRequest request, @ModelAttribute("LoginRequest")LoginRequestModel user) {
		 if(_service.CheckLogin(user.getEmail(), user.getPassword())){
			 var userInfo = _service.GetUserByEmail(user.getEmail());
			 request.getSession().setAttribute("User", userInfo);
			 return "redirect:/";
		 }
		 
		 model.addAttribute("alert", "Đăng nhập thất bại!!!");
		 return "/Client/Login";
	 }
	 
	 @RequestMapping(value = "/Register", method = RequestMethod.GET)
	 public String RegisterPageGet(Model model, HttpServletRequest request) {
		 var userInfo = request.getSession().getAttribute("User");
		 if(userInfo != null) {
			 request.getSession().removeAttribute("User");
		 }
		 
		 return "/Client/Register";
	 }
	 
	 @RequestMapping(value = "/Register", method = RequestMethod.POST)
	 public String RegisterPagePost(Model model, HttpServletRequest request, @ModelAttribute("RegisterRequest")RegisterRequestModel user) {
		 try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(_service.AddUser(user.getName(), 0, user.getBirthDay(), user.getEmail(), 
				 user.getToken(), user.getPhone(), user.getAddress())) {
			 return "redirect:/";
		 }
		 
		 return "/Client/Register";
	 }
	 
	 @RequestMapping(value = "/Profile", method = RequestMethod.GET)
	 public String ProfilePage(Model model, HttpServletRequest request) {
		 var userInfo = request.getSession().getAttribute("User");
		 if(userInfo != null) {
			 model.addAttribute("UserInfo", userInfo);
			 return "/Client/Profile";
		 }
		 
		 return "redirect:/Login";
	 }
	 
	 @RequestMapping(value = "/CheckOut", method = RequestMethod.POST)
	 public String CheckOut(Model model, HttpServletRequest request, @ModelAttribute("CheckOut")CheckOutCardRequestModel cart) {
		 if(_service.CheckOutCard(cart.getProductId(), cart.getQuantity(), cart.getNameReceive(), 
				 cart.getPhoneReceive(), cart.getAddressReceive() + " " + cart.getDistrict() + " " + cart.getCity().split("-")[1], cart.getNote(), 1, Float.parseFloat(cart.getTotalPrice()), Integer.parseInt(cart.getCustomerId()))) {
			 return "/Client/CheckOutSuccess";
		 }
		 
		 return "/Client/order";
	 }
}




















