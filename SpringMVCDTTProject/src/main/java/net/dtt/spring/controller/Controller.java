package net.dtt.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.dtt.spring.dao.TestDao;
import net.dtt.spring.entity.Test;

@org.springframework.stereotype.Controller
public class Controller {
	 @Autowired
	 private TestDao testDao;

	 @RequestMapping({ "/", "/trang-chu", "/index" })
	 public String home(Model model) {
	     return "/Client/index";
	 }
	 
	 @RequestMapping(value = "/deptList", method = RequestMethod.GET)
	 public String deptListGet(Model model) {	
	     List<Test> list = testDao.listTestData();
	     model.addAttribute("test", list);
	     return "/Admin/testList";
	 }
	 
	 @RequestMapping(value = "/deptList", method = RequestMethod.POST)
	 public String deptListPost(Model model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("note") String note) {
		 testDao.createTestData(id, name, note);
	
	     List<Test> list = testDao.listTestData();
	     model.addAttribute("test", list);
	     return "/Admin/testList";
	 }
}
