package com.lzk.springboot2.mapper;

import com.lzk.springboot2.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lzk on 2018/1/20 15:09
 * Description:
 */
// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
public interface UserMapper {
    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(@Param("id") Integer id, @Param("user") User user);

    public int delete(Integer id);
}
