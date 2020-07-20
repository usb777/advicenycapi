package com.advicenyc.springbootcrudrest.services;

import java.util.List;

import com.advicenyc.springbootcrudrest.model.Users;



public interface IUsersService 
{
	
	  public List<Users> getUsers();
	  public Users getUsersByID(int id);
	  public Users saveNewUsers(Users u);
	  public Users updateUsers(Users u);
	  public void deleteUsers(int id);
}
