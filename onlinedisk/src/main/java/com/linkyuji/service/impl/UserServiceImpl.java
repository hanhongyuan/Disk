package com.linkyuji.service.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linkyuji.IDao.UsersMapper;
import com.linkyuji.pojo.Users;
import com.linkyuji.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersMapper userDao;
	
	@Transactional
	public boolean getLoginUser(Users userLogin) {
		// TODO Auto-generated method stub
		if (userLogin.getUserid().equals("") || (userLogin.getUserpsw().equals(""))) {
			return false;
		} else {

			Users user = new Users();
			if (this.userDao.selectLogin(userLogin.getUserid()) != null) {

				user = userDao.selectLogin(userLogin.getUserid());

				if (user.toString().isEmpty()) {

					return false;
				} else {

					if (user.getUserpsw().equals(userLogin.getUserpsw())) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		
	}
	
	public List<Users> loadAllUsers(){
		return this.userDao.loadAllUsers();
	}

	public Users getUserById(String id) {
		// TODO Auto-generated method stub
		return this.userDao.selectId(id);
	}
	@Transactional
	public boolean regiest(Users users) {
		// TODO Auto-generated method stub
		if(users.getUserid().equals("")||users.getUserpsw().equals("")){
			return false;
		}else{
			Users userSql = userDao.selectLogin(users.getUserid());
			if(userSql!=null)
				return false;
			users.setUsername(users.getUserid());
			boolean flag =  userDao.regiest(users);
			return flag;
			
		}
		
	}

}
