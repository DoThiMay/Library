package com.springmvc.library1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.library1.models.User;
import com.springmvc.library1.respositories.BookRespository;
import com.springmvc.library1.respositories.UserRespository;

@Controller
@RequestMapping(path = "users")
public class UserController {
	@Autowired
	private UserRespository userRespository;
	@Autowired
	private BookRespository bookRespository;
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	 public String getAllUser(ModelMap modelMap) {
        Iterable<User> user = userRespository.findAll();
        modelMap.addAttribute("user", user);
        return "User"; //"productList.jsp"
    }
}
