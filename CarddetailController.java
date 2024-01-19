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
		for (Carddetail carddetail2 : carddetail) {
			carddetail2.setCardID("C100");
		}
	        modelMap.addAttribute("carddetail", carddetail);
		modelMap.addAttribute("carddetail1", new Carddetail()); 
	        return "carddetailList"; //"productList.jsp"
	    }
	//	 ../../carddetail/getUpdateStatus
	@RequestMapping(value = "/getUpdateStatus/{bookID}", method = RequestMethod.POST)
	public String getUpdateStatus(ModelMap modelMap, @Validated @ModelAttribute("carddetail1") Carddetail carddetail,
			BindingResult BindingResult, @PathVariable String bookID) {
		Optional<Carddetail> foundCarddetail = carddetailRespository.findById(carddetail.getBookID());
		Carddetail foundCarddetail1 = foundCarddetail.get();
		if (foundCarddetail.isPresent()) {
			if (foundCarddetail1.getStatus().equals("NY")) {
				foundCarddetail1.setStatus("Returned");
			} else {
				foundCarddetail1.setStatus("NY");
			}
			carddetailRespository.save(foundCarddetail1);
		}
		return "redirect:/carddetail/getCarddetailByCardID/" + foundCarddetail1.getCardID();
	}
}
