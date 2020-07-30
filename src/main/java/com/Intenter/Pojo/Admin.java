package com.Intenter.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Long id;   //用户id
    private String username;//用户名
    private String password;//密码
    private String phone;//手机号码
    private String name;//用户昵称

}