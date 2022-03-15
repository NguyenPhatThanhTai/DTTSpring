package net.dtt.spring.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
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
}
