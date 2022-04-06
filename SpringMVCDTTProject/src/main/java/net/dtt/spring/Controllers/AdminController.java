package net.dtt.spring.Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dtt.spring.Enum.EnumClass;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
import net.dtt.spring.Models.ViewModels.AddProductRequestModel;
import net.dtt.spring.Models.ViewModels.CommentViewModel;
import net.dtt.spring.Models.ViewModels.DetailProductViewModel;
import net.dtt.spring.Models.ViewModels.LoginRequestModel;
import net.dtt.spring.Service.IService;

@Controller
@RequestMapping(value = {"/Admin"})
public class AdminController {
	@Autowired
	private IService _service;
	
	 @RequestMapping(value = {"/"}, method = RequestMethod.GET)
	 public String AdminHome(Model model, HttpServletRequest request) {
		 var userInfo = request.getSession().getAttribute("Admin");
		 if(userInfo == null || userInfo != EnumClass.AdminToken) {
			 return "redirect:/";
		 }
		 
		 model.addAttribute("All_Category", _service.getAllCategory());
		 model.addAttribute("All_Manufactors", _service.getAllManufacturers());
		 model.addAttribute("All_Product", _service.GetAllProduct(1, null));
	     return "/Admin/ProductManagment";
	 }
	
	 @RequestMapping(value = "/Login", method = RequestMethod.GET)
	 public String LoginPageGet(Model model, HttpServletRequest request) {
		 var userInfo = request.getSession().getAttribute("Admin");
		 if(userInfo != null) {
			 request.getSession().removeAttribute("Admin");
		 }
		 
		 return "/Admin/Login";
	 }
	 
	 @RequestMapping(value = "/Login", method = RequestMethod.POST)
	 public String LoginPagePost(Model model, HttpServletRequest request, @ModelAttribute("LoginRequest")LoginRequestModel user) {
		 if(_service.CheckLoginAdmin(user.getEmail(), user.getPassword())){
			 request.getSession().setAttribute("Admin", EnumClass.AdminToken);
			 return "redirect:/Admin/";
		 }
		 
		 model.addAttribute("alert", "Đăng nhập thất bại!!!");
		 return "/Admin/Login";
	 }
	 
	 @RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	 public String AddProduct(Model model, HttpServletRequest request, @ModelAttribute("AddProduct")AddProductRequestModel product) {
		 if(_service.AddProduct(Integer.parseInt(product.getManufactorsId()), Integer.parseInt(product.getCategoryId()), product.getName(), product.getDescripsion(), Float.parseFloat(product.getPrice()),
				 product.getImg_cover(), product.getImg_hover(), product.getImg_detail1(), product.getImg_detail2(), product.getImg_detail3(), product.getImg_detail4()))
			 model.addAttribute("alert", "Thêm thành công");
		 model.addAttribute("alert", "Thêm thất bại");
		 
		 return "redirect:/Admin/";
	 }
	 
	 @RequestMapping(value = "/GetProductJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody DetailProductViewModel GetProductJson(Model model, HttpServletRequest request,@RequestParam(value="prodId") int prodId) {
		 var productDetail = _service.GetDetailproduct(prodId);
		 
		 DetailProductViewModel detailProduct = new DetailProductViewModel(productDetail.getProductDetail().getId(), productDetail.getProductDetail().getName(),
				 productDetail.getProductDetail().getDescription(), productDetail.getProductDetail().getPrice(), productDetail.getProductDetail().getImg_Cover(),
				 productDetail.getProductDetail().getImg_Hover(), productDetail.getProductDetail().getImg_Detail1(), 
				 productDetail.getProductDetail().getImg_Detail2(), productDetail.getProductDetail().getImg_Detail3(), productDetail.getProductDetail().getImg_Detail4(),
				 0, productDetail.getId(), productDetail.getCategory().getId(), productDetail.getManufacturers().getId());
		 
		 return detailProduct;
	 }
	 
	 @RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
	 public String UpdateProduct(Model model, HttpServletRequest request, @ModelAttribute("Product")AddProductRequestModel product) {
		 if(_service.UpdateProduct(Integer.parseInt(product.getProductId()), Integer.parseInt(product.getManufactorsId()), Integer.parseInt(product.getCategoryId()), Integer.parseInt(product.getId()), product.getName(), product.getDescripsion(), Float.parseFloat(product.getPrice()),
				 product.getImg_cover(), product.getImg_hover(), product.getImg_detail1(), product.getImg_detail2(), product.getImg_detail3(), product.getImg_detail4()))
			 model.addAttribute("alert", "Sửa thành công");
		 model.addAttribute("alert", "Sửa thất bại");
		return "redirect:/Admin/";
	 }
	 
	 @RequestMapping(value = "/DeleteProduct", method = RequestMethod.POST)
	 public String DeleteProduct(Model model, HttpServletRequest request, @RequestParam("prodId") int prodId) {
		 
		 if(_service.UpdateStatusProduct(prodId)) {
			 
		 }
		 
		 return "redirect:/Admin/";
	 }
}
