package com.example.test.server.api_server.mapper;

import java.util.List;

import com.example.test.server.api_server.model.UserProfile;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserProfileMapper {
    
    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM UserProfile WHERE id=#{id} and pwd=#{pwd}")
    UserProfile getLoginCheck(@Param("id") String id, @Param("pwd") String pwd);

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO UserProfile(id, pwd, name, age) VALUES(#{id}, #{pwd}, #{name}, #{age})")
    int insertUserProfile(UserProfile profile);

    @Update("UPDATE UserProfile SET pwd=#{pwd}, name=#{name}, age=#{age} WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id, @Param("pwd") String pwd, @Param("name") String name, @Param("age") String age);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);
}
