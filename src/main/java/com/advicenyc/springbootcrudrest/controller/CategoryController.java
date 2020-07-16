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
import com.advicenyc.springbootcrudrest.model.Category;
import com.advicenyc.springbootcrudrest.services.ICategoryService;





@RestController
@RequestMapping("/category")
public class CategoryController 
{
	private ICategoryService cs;
	
	 @Autowired
	    public CategoryController(ICategoryService cs)
	 {
	        this.cs = cs;
	  }
	 
	  @GetMapping
	    public ResponseEntity<List<Category>> getAllCategory() {
	        return new ResponseEntity(cs.getCategories(), HttpStatus.OK);
	    }
	  
	  @GetMapping("/categorybyid/{id}")
		public ResponseEntity getVisualizationById(@PathVariable int id) {
			if(id == 0 ) {
				return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Category>(cs.getCategoryByID(id), HttpStatus.OK);
		}


}
