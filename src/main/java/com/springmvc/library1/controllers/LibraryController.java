package com.springmvc.library1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.library1.models.Book;
import com.springmvc.library1.respositories.BookRespository;

//http:localhost:8081/library
@Controller
@RequestMapping(path = "library")
public class LibraryController {
	 @Autowired //Inject "categoryRepository" - Dependency Injection
	    private BookRespository bookRespository;
	 @RequestMapping(value = "", method = RequestMethod.GET)
	    public String getAllLibrary(ModelMap modelMap) {
		//data sent to jsp => ModelMap
	        //send data from Controller to View
	        //modelMap.addAttribute("name", "Hoang");
	        //modelMap.addAttribute("age", 18);
	        Iterable<Book> book = bookRespository.findAll();
	        modelMap.addAttribute("book", book);
	        System.out.println("haha");
	        return "library";
	    }
}