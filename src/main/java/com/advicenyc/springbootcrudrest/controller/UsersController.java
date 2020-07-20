package com.advicenyc.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.advicenyc.springbootcrudrest.exception.RecordNotFoundException;
import com.advicenyc.springbootcrudrest.model.Users;
import com.advicenyc.springbootcrudrest.services.IUsersService;





@RestController
@RequestMapping("/users")
public class UsersController 
{
	private IUsersService us;
	
	 @Autowired
	    public UsersController(IUsersService us)
	 {
	        this.us = us;
	  }
	 
	  @GetMapping
	    public ResponseEntity<List<Users>> getAllCategory() {
	        return new ResponseEntity(us.getUsers(), HttpStatus.OK);
	    }
	  
	  @GetMapping("/{id}")
		public ResponseEntity getVisualizationById(@PathVariable int id) {
			if(id == 0 ) {
				return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Users>(us.getUsersByID(id), HttpStatus.OK);
		}
	  
	  

	    @PostMapping
	    public ResponseEntity<Users> saveNewUsers(@RequestBody Users u)
	    {
	        if(u.getId()!=0)
	        {
	            return new ResponseEntity("Id must be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(us.saveNewUsers(u), HttpStatus.OK);
	    } // postMapping
	    
	    
	    //  Dont patch another field
	    @PatchMapping
	    public ResponseEntity<Users> updateUsers(@RequestBody Users u) 
	    {
	        if (u.getId() == 0) {
	            return new ResponseEntity("User id must not be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(us.updateUsers(u), HttpStatus.CREATED);
	    }

	    @DeleteMapping("{id}")
	    public  ResponseEntity<Object> deleteCategory(@PathVariable int id)
	    {    	
	    	  us.deleteUsers(id);
	    	  return new ResponseEntity( HttpStatus.OK);  	
	    	
	        
	    }  
	    


}
