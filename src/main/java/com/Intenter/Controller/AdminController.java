package com.Intenter.Controller;

import com.Intenter.Pojo.Admin;
import com.Intenter.Pojo.User;
import com.Intenter.Service.AdminService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param userName
     * @param passWord
     * @return user
     */
    @GetMapping("login")
    public ResponseEntity<Admin> Login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {

        Admin admin = adminService.Login(userName, passWord);

        return ResponseEntity.ok(admin);
    }

    /**
     * 注册
     * @param admin
     * @return int
     */
    @PostMapping("save")
    public ResponseEntity<Integer> save(@RequestBody Admin admin) {

        Integer i = adminService.save(admin);

        return ResponseEntity.ok(i);
    }

    /**
     * 修改
     * @param admin
     * @return int
     */
    @PostMapping("update")
    public ResponseEntity<Integer> update(@RequestBody Admin admin) {

        Integer i = adminService.update(admin);

        return ResponseEntity.ok(i);
    }

    /**
     * 删除
     * @param id
     * @return int
     */
    @GetMapping("delete")
    public ResponseEntity<Integer> delete(@RequestParam("id") Long id){
        Integer i = adminService.delete(id);
        return ResponseEntity.ok(i);

    }

    /**
     * 禁用。启用用户
     * @param userId
     * @param stop
     * @return
     */
    @PostMapping("updateStop")
    public ResponseEntity<Integer> updateStop(
            @RequestParam("userId") Long userId ,
            @RequestParam("stop") Integer stop){
        Integer i=adminService.updateStop(userId,stop);
        return ResponseEntity.ok(i);
    }
    
    @GetMapping("findAll")
    public ResponseEntity<IPage<User>> findAll(
            @RequestParam(name = "current",required = true ,defaultValue = "1") Integer current,
            @RequestParam(name = "size",required = true ,defaultValue = "10") Integer size){
        IPage<User> userIPage = adminService.findAll(current,size);
        return ResponseEntity.ok(userIPage);
    }
}
