package com.Intenter.Mapper;

import com.Intenter.Pojo.Collection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

public interface CollectionMapper extends BaseMapper<Collection> {
    @Update("UPDATE collection SET state=1  WHERE id=#{collectionId}")
    Integer updateState(Long collectionId);
}
