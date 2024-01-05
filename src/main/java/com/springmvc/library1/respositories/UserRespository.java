package com.springmvc.library1.respositories;

import org.springframework.data.repository.CrudRepository;

import com.springmvc.library1.models.User;


public interface UserRespository extends CrudRepository<User, String> {

}
