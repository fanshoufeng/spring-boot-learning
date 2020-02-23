package com.fanshoufeng.mybatis.mapper;

import com.fanshoufeng.mybatis.enums.UserSex;
import com.fanshoufeng.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Repository
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSex.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSex.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);

    @Insert("insert into user(username, password, user_sex) values (#{username}, #{password}, #{userSex})")
    void insert(User user);

    @Update("update user set username = #{username}, nick_name = #{nickName} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(Long id);

}
