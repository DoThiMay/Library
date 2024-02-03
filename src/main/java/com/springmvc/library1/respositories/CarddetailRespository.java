package com.springmvc.library1.respositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.springmvc.library1.models.Carddetail;

public interface CarddetailRespository extends CrudRepository<Carddetail, String>{
  @Query(value = "SELECT COUNT(carddetails.status) as StatusCount FROM Book Inner Join carddetails ON Book.bookID= carddetails.bookID Where carddetails.status=?2 and Book.bookID=?1 GROUP BY Book.bookID", nativeQuery = true)
	Integer getAvaiableBookNumber(String bookID, String Status);
	
	Iterable<Carddetail> findByCardID(String cardID);
	
	@Query(value = "Select * from carddetails where cardID = ?1 and bookID = ?2", nativeQuery = true)	
	Optional<Carddetail> findBook(String cardID, String bookID);
}
