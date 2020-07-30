package com.Intenter.Mapper;

import com.Intenter.Pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

public interface AdminMapper extends BaseMapper<Admin> {
    @Update("UPDATE user SET stop=#{stop}  WHERE id=#{userId}")
    Integer updateStop(Long userId,Integer stop);
}
