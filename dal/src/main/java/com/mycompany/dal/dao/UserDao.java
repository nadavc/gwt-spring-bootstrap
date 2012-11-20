package com.mycompany.dal.dao;

import org.apache.ibatis.annotations.Select;
import com.mycompany.shared.User;

public interface UserDao {

    @Select("select username, password, authorities from users where username = #{username}")
    User readUser(String username);

}
