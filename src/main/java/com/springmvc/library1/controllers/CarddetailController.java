package com.springmvc.library1.controllers;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.library1.models.Book;
import com.springmvc.library1.models.Carddetail;
import com.springmvc.library1.respositories.BookRespository;
import com.springmvc.library1.respositories.CarddetailRespository;
import com.springmvc.library1.respositories.LibrarycardRespository;

@Controller
@RequestMapping(path = "carddetail")
public class CarddetailController {
	@Autowired
	CarddetailRespository carddetailRespository;
	@RequestMapping(value = "/getCarddetailByCardID/{cardID}", method = RequestMethod.GET)
	public String getCarddetailByCardID(ModelMap modelMap, @PathVariable String cardID) {
		Iterable<Carddetail> carddetail = carddetailRespository.findByCardID(cardID);
//		for (Carddetail carddetail2 : carddetail) {
//			carddetail2.setCardID("C100");
//		}
		modelMap.addAttribute("carddetail", carddetail);
		modelMap.addAttribute("carddetail1", new Carddetail()); 
		return "carddetailList"; // "productList.jsp"
	}
	@Autowired
	private BookRespository bookRespository;
	
//	 ../../carddetail/getUpdateStatus
	@RequestMapping(value = "/getUpdateStatus/{bookID}", method = RequestMethod.POST)
	public String getUpdateStatus(ModelMap modelMap, @Validated @ModelAttribute("carddetail1") Carddetail carddetail,
			BindingResult BindingResult, @PathVariable String bookID) {
		Optional<Carddetail> foundCarddetail = carddetailRespository.findBook(carddetail.getCardID(), carddetail.getBookID());
		Carddetail foundCarddetail1 = foundCarddetail.get();
		Book book = bookRespository.findBookByID(carddetail.getBookID());
		if (foundCarddetail.isPresent()) {
			if (foundCarddetail1.getStatus().equals("NY")) {
				foundCarddetail1.setStatus("Returned");
				book.setNumber(book.getNumber() + 1);
			} else {
				foundCarddetail1.setStatus("NY");
				book.setNumber(book.getNumber() - 1);
			}
			bookRespository.save(book);
			carddetailRespository.save(foundCarddetail1);
//			carddetailRespository.updateCarddetail(foundCarddetail1.getCardID(), foundCarddetail1.getBookID(), foundCarddetail1.getStatus());
		}
		return "redirect:/carddetail/getCarddetailByCardID/" + foundCarddetail1.getCardID();
	}
	
	
//	@RequestMapping(value = "/getUpdateNumber", method = RequestMethod.POST)
//	public String getUpdateNumber(ModelMap modelMap, @Validated @ModelAttribute("book1") Book book) {
//		Iterable<Book> book = bookRespository.findAll();
//		for (Book Book2 : book) {
//	        	int ny = 0;        	
//	        	// get ny
//	        	if (carddetailRespository.getAvaiableBookNumber(Book2.getBookID(), "NY") != null) {
//	        		ny = carddetailRespository.getAvaiableBookNumber(Book2.getBookID(), "NY");
//		        }
//	        	if (Book2.getBookID().equals("B01")) {
//	        		Book2.setNumber(13 - ny );
//	        	}
//	        	if (Book2.getBookID().equals("B03")) {
//	        		Book2.setNumber(55 - ny );
//	        	}
//	        	Book2.setNumber(Book2.getNumber() - ny );
//	        	bookRespository.save(Book2);
//	        	bookRespository.updateNumber(Book2.getBookID(), Book2.getNumber());
//			}
//			return "redirect:/library";
//	}
	
}
