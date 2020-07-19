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
    
	
	@Override
	public Role getRoleByID(int id) 
	{
		return rd.getOne(id);
	}
    
	
	 @Override
	 public Role saveNewRole(Role r) 
	 {
	        return rd.save(r);
	 }

    /**
     * Sort method:Dzimtry
     * 
     * @Override public List<Role> getAllRoles() { return
     *           ud.findAll(Sort.by(Sort.Direction.ASC, "id")); //Sorted By    *  
     *                    userId asc }
     * 
     */
	
    
    
    
	   @Override
	    @Transactional
	    public Role updateRole(Role r) 
	   {
	        Role oldC = rd.getOne(r.getId());
	       
	        if (r.getRole() != null) 
	        {
	            oldC.setRole(r.getRole());
	        }
	        return oldC;
	    }
	    

	    @Override
	    public void deleteRole(int id)
	    {
	        Role oldC = rd.getOne(id);
	        rd.deleteById(id);
	       
	    }


}