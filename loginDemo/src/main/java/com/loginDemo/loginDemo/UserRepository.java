package com.loginDemo.loginDemo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends CrudRepository<UserModel, Integer> {
	@Query(" from UserModel um where um.userName=:userName and um.password=:password ")
	public UserModel getUserByNameAndPassword(@Param("userName")String userName ,@Param("password") String password);
	
	public List<UserModel> findBySalaryGreaterThan(Long salary, Pageable pageable);
	public List<UserModel> findByUserNameAndUserId(String findByUserName,Integer userId, Pageable pageable);
	public List<UserModel> findAll(Pageable pageable);
	public List<UserModel> findAll();
}
