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
import com.advicenyc.springbootcrudrest.model.Role;
import com.advicenyc.springbootcrudrest.services.IRoleService;





@RestController
@RequestMapping("/role")
public class RoleController 
{
	private IRoleService rs;
	
	 @Autowired
	    public RoleController(IRoleService rs)
	 {
	        this.rs = rs;
	  }
	 
	  @GetMapping
	    public ResponseEntity<List<Role>> getAllCategory() {
	        return new ResponseEntity(rs.getRoles(), HttpStatus.OK);
	    }
	  
	  /*
	  @GetMapping("/{id}")
		public ResponseEntity getVisualizationById(@PathVariable int id) {
			if(id == 0 ) {
				return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Category>(cs.getCategoryByID(id), HttpStatus.OK);
		}
	  
	  

	    @PostMapping
	    public ResponseEntity<Category> saveNewCategory(@RequestBody Category c){
	        if(c.getId()!=0){
	            return new ResponseEntity("Id must be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(cs.saveNewCategory(c), HttpStatus.OK);
	    }
	    
	    
	    
	    @PatchMapping
	    public ResponseEntity<Category> updateCategory(@RequestBody Category c) {
	        if (c.getId() == 0) {
	            return new ResponseEntity("Category id must not be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(cs.updateCategory(c), HttpStatus.CREATED);
	    }

	    @DeleteMapping("{id}")
	    public  ResponseEntity<Object> deleteCategory(@PathVariable int id){    	
	    	  cs.deleteCategory(id);
	    	  return new ResponseEntity( HttpStatus.OK);  	
	    	
	        
	    }  //deleteCategory(@PathVariable int id)
	    
*/

}
