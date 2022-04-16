package net.dtt.spring.Controllers;

import java.util.ArrayList;
import java.util.List;

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
import net.dtt.spring.Models.DAOModel.DetailOrdersDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
import net.dtt.spring.Models.ViewModels.AddCategoryRequestModel;
import net.dtt.spring.Models.ViewModels.AddManufactorRequestModel;
import net.dtt.spring.Models.ViewModels.AddProductRequestModel;
import net.dtt.spring.Models.ViewModels.CategoryViewModel;
import net.dtt.spring.Models.ViewModels.CommentViewModel;
import net.dtt.spring.Models.ViewModels.DetailOrderViewModel;
import net.dtt.spring.Models.ViewModels.DetailProductViewModel;
import net.dtt.spring.Models.ViewModels.LoginRequestModel;
import net.dtt.spring.Models.ViewModels.ManufactorViewModel;
import net.dtt.spring.Models.ViewModels.OrderViewModel;
import net.dtt.spring.Service.IService;
import net.dtt.spring.ServiceDTO.MailDTO;

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
	 
	 @RequestMapping(value = "/ManufactorManagment", method = RequestMethod.GET)
	 public String ManufactorPage(Model model, HttpServletRequest request) {
		 model.addAttribute("List_Manufactor", _service.getAllManufacturers());
		 
		 return "/Admin/ManufactorManagment";
	 }
	 
	 @RequestMapping(value = "/AddManufactor", method = RequestMethod.POST)
	 public String AddManufactor(Model model, HttpServletRequest request, @ModelAttribute("AddManufactor")AddManufactorRequestModel manufactor) {
		 if(_service.AddManufactor(manufactor.getName()))
			 model.addAttribute("alert", "Thêm thành công");
		 model.addAttribute("alert", "Thêm thất bại");
		 
		 return "redirect:/Admin/ManufactorManagment";
	 }
	 
	 @RequestMapping(value = "/GetManufactorJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ManufactorViewModel GetManufactorJson(Model model, HttpServletRequest request,@RequestParam(value="manufactorId") int id) {
		 var manufactor = _service.GetManufactor(id);
		 
		 return new ManufactorViewModel(manufactor.getId(), manufactor.getName());
	 }
	 
	 @RequestMapping(value = "/UpdateManufactor", method = RequestMethod.POST)
	 public String UpdateManufactor(Model model, HttpServletRequest request, @ModelAttribute("UpdateManufactor")AddManufactorRequestModel manufactor) {
		 if(_service.UpdateManufactor(manufactor.getId(), manufactor.getName()))
			 model.addAttribute("alert", "Sửa thành công");
		 model.addAttribute("alert", "Sửa thất bại");
		 
		 return "redirect:/Admin/ManufactorManagment";
	 }
	 
	 @RequestMapping(value = "/DeleteManufactor", method = RequestMethod.POST)
	 public String DeleteManufactor(Model model, HttpServletRequest request, @RequestParam("manufactorId") int id) {
		 if(_service.DeleteManufactor(id))
			 model.addAttribute("alert", "Xóa thành công");
		 model.addAttribute("alert", "Xóa thất bại");
		 
		 return "redirect:/Admin/ManufactorManagment";
	 }
	 
	 @RequestMapping(value = "/CategoryManagment", method = RequestMethod.GET)
	 public String CategoryPage(Model model, HttpServletRequest request) {
		 model.addAttribute("List_Category", _service.getAllCategory());
		 
		 return "/Admin/CategoryManagment";
	 }
	 
	 @RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	 public String AddCategory(Model model, HttpServletRequest request, @ModelAttribute("AddCategory")AddCategoryRequestModel category) {
		 if(_service.AddCategory(category.getName()))
			 model.addAttribute("alert", "Thêm thành công");
		 model.addAttribute("alert", "Thêm thất bại");
		 
		 return "redirect:/Admin/CategoryManagment";
	 }
	 
	 @RequestMapping(value = "/GetCategoryJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody CategoryViewModel GetCategoryJson(Model model, HttpServletRequest request,@RequestParam(value="categoryId") int id) {
		 var category = _service.GetCategory(id);
		 
		 return new CategoryViewModel(category.getId(), category.getName());
	 }
	 
	 @RequestMapping(value = "/UpdateCategory", method = RequestMethod.POST)
	 public String UpdateCategory(Model model, HttpServletRequest request, @ModelAttribute("UpdateCategory")AddCategoryRequestModel category) {
		 if(_service.UpdateCategory(category.getId(), category.getName()))
			 model.addAttribute("alert", "Sửa thành công");
		 model.addAttribute("alert", "Sửa thất bại");
		 
		 return "redirect:/Admin/CategoryManagment";
	 }
	 
	 @RequestMapping(value = "/DeleteCategory", method = RequestMethod.POST)
	 public String DeleteCategoryr(Model model, HttpServletRequest request, @RequestParam("categoryId") int id) {
		 if(_service.DeleteCategory(id))
			 model.addAttribute("alert", "Xóa thành công");
		 model.addAttribute("alert", "Xóa thất bại");
		 
		 return "redirect:/Admin/CategoryManagment";
	 }
	 
	 @RequestMapping(value = "/CustomerManagment", method = RequestMethod.GET)
	 public String CustomerManagment(Model model, HttpServletRequest request) {
		 model.addAttribute("list_customer", _service.GetCustomer());
		 
		 return "/Admin/CustomerManagment";
	 }
	 
	 @RequestMapping(value = "/DeleteCustomer", method = RequestMethod.POST)
	 public String DeleteCustomer(Model model, HttpServletRequest request, @RequestParam("customerId") int id) {
		 if(_service.DeleteCustomer(id)) {
			 model.addAttribute("alert", "Xóa thành công");
		 }
		 model.addAttribute("alert", "Xóa thất bại");
		 return "redirect:/Admin/CustomerManagment";
	 }
	 
	 @RequestMapping(value = "/OrderManagment", method = RequestMethod.GET)
	 public String OrderManagmentPage(Model model, HttpServletRequest request) {

		 model.addAttribute("List_Order", _service.GetAllOrder());
		 return "/Admin/OrderManagment";
	 }
	 
	 @RequestMapping(value = "/GetOrderJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody OrderViewModel GetOrderJson(Model model, HttpServletRequest request,@RequestParam(value="orderId") int id) {
		 var order = _service.GetOrderById(id);
		 
		 OrderViewModel orderViewModel = new OrderViewModel();
		 orderViewModel.setAddress(order.getAddressReceive());
		 orderViewModel.setName(order.getNameReceive());
		 orderViewModel.setNote(order.getNote());
		 orderViewModel.setOrderId(order.getId());
		 orderViewModel.setPhone(order.getPhoneReceive());
		 orderViewModel.setStatus(order.getStatus());
		 
		 List<DetailOrderViewModel> detailOrders = new ArrayList<DetailOrderViewModel>();
		 
		 for (DetailOrdersDaoModel detailOrder : order.getDetailOrder()) {
			 DetailOrderViewModel detail = new DetailOrderViewModel();
			 detail.setProductId(detailOrder.getProduct().getId());
			 detail.setProductName(detailOrder.getProduct().getProductDetail().getName());
			 detail.setProductQuantity(detailOrder.getQuantity());
			 
			 detailOrders.add(detail);
		}
		 
		 orderViewModel.setListOrder(detailOrders);
		 
		 return orderViewModel;
	 }
	 
	 @RequestMapping(value = "/UpdateOrderStatus", method = RequestMethod.POST)
	 public String UpdateOrderStatus(Model model, HttpServletRequest request, @RequestParam("OrderId") int OrderId) {
		 
		 MailDTO mail = new MailDTO();
		 mail.sendMail("nguyenphatthanhtai@gmail.com", "Test", _service.GetOrderById(OrderId));
		 
		 if(_service.UpdateOrderStatus(OrderId))
			 model.addAttribute("alert", "Cập nhật thành công");
		 model.addAttribute("alert", "Cập nhật thất bại");
		 
		 return "redirect:/Admin/OrderManagment";
	 } 
	 
	 
	 
	 
	 
	 
	 
}
