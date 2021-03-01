package com.dfs.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.dfs.pma.entities.Project;
import com.dfs.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
