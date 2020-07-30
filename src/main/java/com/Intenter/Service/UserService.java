package com.Intenter.Service;

import com.Intenter.Mapper.UserMapper;
import com.Intenter.Pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userName
     * @param passWord
     * @return
     */
    public User Login(String userName, String passWord) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .eq("username", userName)
                .eq("password",passWord);

        User user = userMapper.selectOne(wrapper);


              // System.out.println(user.toString());
        return user;
    }

    /**
     * 查询所有用户
     * @return users
     */
    public List<User> findAll(){
        List<User> users = userMapper.selectList(null);
        return users;
    }

    /**
     * 注册
     * @param user
     * @return int
     */
    public Integer save(User user) {
        //判断user是否为空
        if(user==null){
            return 0;
        }else {
            //判断用户是否存在
            List<User> users = findAll();
            String username = user.getUsername();
            Boolean lag = true;
            for (User u : users) {
                if (username.equals(u.getUsername())) {
                    lag = false;
                    break;
                }
            }

            if (lag) {
                Integer insert = userMapper.insert(user);
                return insert;
            } else {
                return 0;
            }
        }
    }

    /**
     * 修改
     * @param user
     * @return int
     */
    public Integer update(User user) {
        Integer i = userMapper.updateById(user);
        return  i;

    }

    /**
     * 删除
     * @param id
     * @return int
     */
    public Integer delete(Long id) {
        Integer i = userMapper.deleteById(id);
        return i;
    }

    /**
     * id查询
     * @param id
     * @return user
     */
    public User findById(Long id){
        User user = userMapper.selectById(id);
        return user;
    }
}
