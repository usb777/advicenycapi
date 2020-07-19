package com.advicenyc.springbootcrudrest.services;

import java.util.List;

import com.advicenyc.springbootcrudrest.model.Role;



public interface IRoleService 
{
	
	  public List<Role> getRoles();
	  public Role getRoleByID(int id);
	  public Role saveNewRole(Role r);
	  public Role updateRole(Role r);
	  public void deleteRole(int id);
}
