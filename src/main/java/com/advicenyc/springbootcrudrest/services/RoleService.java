package com.advicenyc.springbootcrudrest.services;

import java.util.List;
import java.util.Optional;


import com.advicenyc.springbootcrudrest.repository_daos.RoleDAOrep;
import com.advicenyc.springbootcrudrest.exception.RecordNotFoundException;
import com.advicenyc.springbootcrudrest.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RoleService implements IRoleService {

    private RoleDAOrep rd;
    
    @Autowired 
    RoleDAOrep repository;

    @Autowired
    public RoleService(RoleDAOrep rd) {
        this.rd = rd;
    }

    @Override
    public List<Role> getRoles() 
    {
        return rd.findAll();
    }
    /*
	
	@Override
	public Category getCategoryByID(int id) 
	{
		return cd.getOne(id);
	}
    
	
	 @Override
	 public Category saveNewCategory(Category c) 
	 {
	        return cd.save(c);
	 }

    /**
     * Sort method:Dzimtry
     * 
     * @Override public List<Users> getAllUsers() { return
     *           ud.findAll(Sort.by(Sort.Direction.ASC, "userId")); //Sorted By
     *           userId asc }
     * 
     */
	
    
    
    /*
	   @Override
	    @Transactional
	    public Category updateCategory(Category c) {
	        Category oldC = cd.getOne(c.getId());
	       
	        if (c.getName() != null) {
	            oldC.setName(c.getName());
	        }
	        return oldC;
	    }
	    

	    @Override
	    public void deleteCategory(int id){
	        Category oldC = cd.getOne(id);
	        cd.deleteById(id);
	       
	    }

*/
}