package com.Intenter.Controller;

import com.Intenter.Pojo.User;
import com.Intenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param userName
     * @param passWord
     * @return user
     */
    @GetMapping("login")
    public ResponseEntity<User> Login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {

         User user = userService.Login(userName, passWord);

        return ResponseEntity.ok(user);
    }

    /**
     * 注册
     * @param user
     * @return int
     */
    @PostMapping("save")
    public ResponseEntity<Integer> save(@RequestBody User user) {

        Integer i = userService.save(user);

        return ResponseEntity.ok(i);
    }

    /**
     * 修改
     * @param user
     * @return int
     */
    @PostMapping("update")
    public ResponseEntity<Integer> update(@RequestBody User user) {

        Integer i = userService.update(user);

        return ResponseEntity.ok(i);
    }

    /**
     * 删除
     * @param id
     * @return int
     */
    @GetMapping("delete")
    public ResponseEntity<Integer> delete(@RequestParam("id") Long id){
        Integer i = userService.delete(id);
        return ResponseEntity.ok(i);

    }



}
