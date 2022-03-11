//package net.dtt.spring.Controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import net.dtt.spring.DataAccess.DataAccess;
//import net.dtt.spring.DataAccess.IDataAccess;
//import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
//import net.dtt.spring.Models.DAOModel.ProductDaoModel;
//import net.dtt.spring.Service.IService;
//import net.dtt.spring.Service.Service;
//import net.dtt.spring.entity.Test;
//
//@Controller
//public class HomeControllers {
//	@Autowired
//	private IService _service;
//	
//	 @RequestMapping(value = {"/", "/ViewAmount/{count}"}, method = RequestMethod.GET)
//	 public String home(Model model, @PathVariable(value="count") int amount) {
//		var ListCategory = _service.getAllCategory();
//		 var listProductRecomment = _service.GetRecommentProduct(amount);
//		 //var ListBestSellerProduct = _dataAccess.GetAllProduct();
//		 
//		 model.addAttribute("list_category", ListCategory);
//		 model.addAttribute("list_product_recomment", listProductRecomment);
//		 //model.addAttribute("list_bestSeller_product", ListBestSellerProduct);
//		 
//	     return "/Client/HomePage";
//	 }
//	 
////	 @RequestMapping(value = "/deptList", method = RequestMethod.GET)
////	 public String deptListGet(Model model) {	
////	     var ListCategory = 
////	     model.addAttribute("ListCategory", ListCategory);
////	     return "/Admin/testList";
////	 }
//	 
////	 @RequestMapping(value = "/deptList", method = RequestMethod.POST)
////	 public String deptListPost(Model model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("note") String note) {
////		 testDao.createTestData(id, name, note);
////	
////	     List<Test> list = testDao.listTestData();
////	     model.addAttribute("test", list);
////	     return "/Admin/testList";
////	 }
//}
