package com.loginDemo.loginDemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CustomRepositery extends PagingAndSortingRepository<UserModel, Long> {

	//Slice<UserModel> findByUserName1(String userName, Pageable pageable);
	@NullMeans(NullBehavior.IGNORED)
	Page<UserModel> findByUserName(String lastname, Pageable pageable);

}