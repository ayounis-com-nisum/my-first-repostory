package com.loginDemo.loginDemo;

import javax.transaction.Transactional;




public interface UserDAO {
	@Transactional
	public void addUserModel(UserModel model);
}
