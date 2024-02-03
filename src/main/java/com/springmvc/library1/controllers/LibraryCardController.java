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
@Autowired
private UserRespository userRespository;
@RequestMapping(value = "/insertLibrarycard", method = RequestMethod.GET)
public String insertLibrarycard(ModelMap modelMap) {
	modelMap.addAttribute("librarycard", new Librarycard());
	modelMap.addAttribute("user", userRespository.findAll());
	return "insertLibrarycard";

}
@RequestMapping(value = "/insertLibrarycard", method = RequestMethod.POST)
public String insertLibrarycard(ModelMap modelMap, @Validated @ModelAttribute("librarycard") Librarycard librarycard,
		BindingResult BindingResult // validation
) {
	if (BindingResult.hasErrors()) {
		return "insertLibrarycard";
	}try {
		
		String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String cardIdRandom = uuid.substring(uuid.length() - 4);
		librarycard.setCardID(cardIdRandom);
		librarycardRespository.save(librarycard);
		return "redirect:/librarycard/getAllLibrarycard";
	} catch (Exception e) {
		modelMap.addAttribute("error", e.toString());
		return "insertLibrarycard";
	}
}
}
