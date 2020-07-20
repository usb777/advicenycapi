package com.advicenyc.springbootcrudrest.services;

import java.util.List;
import java.util.Optional;


import com.advicenyc.springbootcrudrest.repository_daos.UsersDAOrep;
import com.advicenyc.springbootcrudrest.exception.RecordNotFoundException;
import com.advicenyc.springbootcrudrest.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsersService implements IUsersService {

    private UsersDAOrep ud;
    
    @Autowired 
    UsersDAOrep repository;

    @Autowired
    public UsersService( UsersDAOrep ud) {
        this.ud = ud;
    }

    @Override
    public List<Users> getUsers() 
    {
        return ud.findAll();
    }
    
	
	@Override
	public Users getUsersByID(int id) 
	{
		return ud.getOne(id);
	}
    
	
	 @Override
	 public Users saveNewUsers(Users u) 
	 {
	        return ud.save(u);
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
	    public Users updateUsers(Users u) 
	   {
	        Users oldC = ud.getOne(u.getId());
	       
	        if (u.getFullname() != null) 
	        {
	            oldC.setFullname(u.getFullname());
	            oldC.setEmail(u.getEmail());  // added for change
	            oldC.setUsername(u.getUsername());
	            oldC.setPassword(u.getPassword());
	            oldC.setRole(u.getRole());
	        }
	        return oldC;
	    }
	    

	    @Override
	    public void deleteUsers(int id)
	    {
	        Users oldC = ud.getOne(id);
	        ud.deleteById(id);
	       
	    }


}