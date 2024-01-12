package com.springmvc.library1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.library1.models.Carddetail;
import com.springmvc.library1.respositories.CarddetailRespository;
import com.springmvc.library1.respositories.LibrarycardRespository;

@Controller
@RequestMapping(path = "carddetail")
public class CarddetailController {
	 @Autowired 
	 CarddetailRespository carddetailRespository;
	 @Autowired
	 private LibrarycardRespository librarycardRespository;
	 @RequestMapping(value = "/getCarddetailByCardID/{cardID}", method = RequestMethod.GET)
	    public String getCarddetailByCardID(ModelMap modelMap, @PathVariable String cardID) {
	        Iterable<Carddetail> carddetail = carddetailRespository.findByCardID(cardID);
	        modelMap.addAttribute("carddetail", carddetail);
	        return "carddetailList"; //"productList.jsp"
	    }
}
