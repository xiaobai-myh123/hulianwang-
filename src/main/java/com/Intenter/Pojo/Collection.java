package com.Intenter.Pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {

    private Long id; //募捐id
    private Long userid; //用户id
    private String username ;//发起人
    private String name;//发起人昵称
    private String departaddr; //发货地址
    private String destinationaddr;//目的地

   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date begintime; //发起时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime; //结束时间
    private Integer state; //状态

    private String text;//内容
}
