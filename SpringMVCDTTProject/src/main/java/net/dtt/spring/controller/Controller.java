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
	 
	 @RequestMapping({ "/deptList" })
	 public String deptList(Model model) {
//		 testDao.createTestData("1", "Dept Name", "Dept Location");
	
	     List<Test> list = testDao.listTestData();
	     model.addAttribute("test", list);
	     return "/Admin/testList";
	 }
}
