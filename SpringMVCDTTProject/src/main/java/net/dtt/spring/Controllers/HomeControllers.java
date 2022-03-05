package net.dtt.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dtt.spring.DataAccess.IDataAccess;

@Controller
@RequestMapping({ "/home/*" })
public class HomeControllers {
	private IDataAccess _dataAccess;
}
