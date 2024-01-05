package com.springmvc.library1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.library1.models.Librarycard;
import com.springmvc.library1.respositories.LibrarycardRespository;

@Controller
@RequestMapping(path = "librarycard")
public class LibraryCardController {
@Autowired
private LibrarycardRespository librarycardRespository;
@RequestMapping(value = "/getAllLibrarycard", method = RequestMethod.GET)
public String getAllUser(ModelMap modelMap) {
    Iterable<Librarycard> librarycard = librarycardRespository.findAll();
    modelMap.addAttribute("librarycard", librarycard);
    return "librarycard"; //"productList.jsp"
}

}
