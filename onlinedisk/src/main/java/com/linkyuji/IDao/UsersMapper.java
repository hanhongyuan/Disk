package com.linkyuji.IDao;


import java.util.List;

import com.linkyuji.pojo.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer idusers);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer idusers);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    Users selectLogin(String userid);
    
    Users selectId(String id);
    
    boolean regiest(Users users);
    
    List<Users> loadAllUsers();
}