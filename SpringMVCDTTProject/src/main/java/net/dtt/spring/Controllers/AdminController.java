package net.dtt.spring.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dtt.spring.Enum.EnumClass;
import net.dtt.spring.Models.ViewModels.AddProductRequestModel;
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
	 public String AddProduct(Model model, HttpServletRequest request, @ModelAttribute("AddProduct")AddProductRequestModel user) {
		 
		 return "redirect:/";
	 }
}
