package com.Intenter.Service;

import com.Intenter.Mapper.AdminMapper;
import com.Intenter.Mapper.UserMapper;
import com.Intenter.Pojo.Admin;
import com.Intenter.Pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param userName
     * @param passWord
     * @return
     */
    public Admin Login(String userName, String passWord) {

        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper
                .eq("username", userName)
                .eq("password",passWord);

        Admin admin = adminMapper.selectOne(wrapper);


        // System.out.println(user.toString());
        return admin;
    }

    /**
     * 查询所有用户
     * @return users
     */
    public List<Admin> findAlladmin(){
        List<Admin> admins = adminMapper.selectList(null);
        return admins;
    }

    /**
     * 查询所有用户
     * @return users
     */
    public IPage<User> findAll(Integer current,Integer size){
        Page<User> page = new Page<>(current, size);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        return userIPage;
    }

    /**
     * 注册
     * @param admin
     * @return int
     */
    public Integer save(Admin admin) {
        //判断user是否为空
        if(admin==null){
            return 0;
        }else {
            //判断用户是否存在
            List<Admin> admins = findAlladmin();
            String username = admin.getUsername();
            Boolean lag = true;
            for (Admin a : admins) {
                if (username.equals(a.getUsername())) {
                    lag = false;
                    break;
                }
            }

            if (lag) {
                Integer insert = adminMapper.insert(admin);
                return insert;
            } else {
                return 0;
            }
        }
    }

    /**
     * 修改
     * @param admin
     * @return int
     */
    public Integer update(Admin admin) {

        Integer i = adminMapper.updateById(admin);
        return  i;

    }

    /**
     * 删除
     * @param id
     * @return int
     */
    public Integer delete(Long id) {
        Integer i = adminMapper.deleteById(id);
        return i;
    }

    /**
     * id查询
     * @param id
     * @return user
     */
    public Admin findById(Long id){
        Admin admin = adminMapper.selectById(id);
        return admin;
    }

    /**
     * 禁用。启用用户
     * @param userId
     * @param stop
     * @return
     */
    public Integer updateStop(Long userId, Integer stop) {
        if(stop==0){
            stop=1;
            return  adminMapper.updateStop(userId, stop);

        }else{
            stop=0;
            return  adminMapper.updateStop(userId, stop);
        }
    }
}
