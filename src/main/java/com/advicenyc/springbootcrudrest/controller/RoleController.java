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
	    public ResponseEntity<List<Role>> getAllRoles() {
	        return new ResponseEntity(rs.getRoles(), HttpStatus.OK);
	    }
	  
	  
	  @GetMapping("/{id}")
		public ResponseEntity getRoleById(@PathVariable int id) {
			if(id == 0 ) 
			{
				return new ResponseEntity<>("Id must not be 0", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Role>(rs.getRoleByID(id), HttpStatus.OK);
		}
	  
	  

	    @PostMapping
	    public ResponseEntity<Role> saveNewRole(@RequestBody Role r){
	        if(r.getId()!=0)
	        {
	            return new ResponseEntity("Id must be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(rs.saveNewRole(r), HttpStatus.OK);
	    }
	    
	    
	     
	    @PatchMapping
	    public ResponseEntity<Role> updateRole(@RequestBody Role r) {
	        if (r.getId() == 0) {
	            return new ResponseEntity("Role id must not be 0", HttpStatus.BAD_REQUEST);
	        }
	        return new ResponseEntity(rs.updateRole(r), HttpStatus.CREATED);
	    }

	    @DeleteMapping("{id}")
	    public  ResponseEntity<Object> deleteRole(@PathVariable int id)
	    {    	
	    	  rs.deleteRole(id);
	    	  return new ResponseEntity( HttpStatus.OK);  
	    }  //deleteCategory(@PathVariable int id)
	    


}
