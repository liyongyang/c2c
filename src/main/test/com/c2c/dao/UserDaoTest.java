package com.c2c.dao;

import com.c2c.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-context-dao.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /**
     * 测试通过用户名和密码查询用户
     */
    @Test
    public void findUserByUsernameAndPassword() {
        User findUser = userDao.findUserByUsernameAndPassword("123123", "123123");
        assertNotNull(findUser);
    }

    /**
     * 测试新增用户
     */
    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("123123");
        user.setPassword("123123");
        user.setPhone(18784066928L);
        userDao.insertUser(user);
    }

    /**
     * 测试通过用户id修改用户密码
     */
    @Test
    public void updatePasswordByUserId() {
        userDao.updatePasswordByUserId(1L, "321321");
    }

    /**
     * 测试删除用户
     */
    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1L);
    }
}
