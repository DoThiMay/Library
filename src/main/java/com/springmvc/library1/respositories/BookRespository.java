package com.springmvc.library1.respositories;
import org.springframework.data.repository.CrudRepository;

import com.springmvc.library1.models.Book;

public interface BookRespository extends CrudRepository<Book, String>{

}