package com.advicenyc.springbootcrudrest.services;

import java.util.List;
import java.util.Optional;

import com.advicenyc.springbootcrudrest.repository_daos.CategoryDAOrep;

import com.advicenyc.springbootcrudrest.exception.RecordNotFoundException;
import com.advicenyc.springbootcrudrest.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CategoryService implements ICategoryService {

    private CategoryDAOrep cd;
    
    @Autowired 
    CategoryDAOrep repository;

    @Autowired
    public CategoryService(CategoryDAOrep cd) {
        this.cd = cd;
    }

    @Override
    public List<Category> getCategories() 
    {
        return cd.findAll();
    }
    
	
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


}