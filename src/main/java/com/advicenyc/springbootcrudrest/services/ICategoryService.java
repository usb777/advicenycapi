package com.advicenyc.springbootcrudrest.services;

import java.util.List;

import com.advicenyc.springbootcrudrest.model.Category;



public interface ICategoryService 
{
	
	  public List<Category> getCategories();
	  public Category getCategoryByID(int id);
	
	  
}
