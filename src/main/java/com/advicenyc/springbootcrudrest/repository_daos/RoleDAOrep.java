package com.advicenyc.springbootcrudrest.repository_daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advicenyc.springbootcrudrest.model.Role;


@Repository
public interface RoleDAOrep extends JpaRepository<Role, Integer>
{

}
