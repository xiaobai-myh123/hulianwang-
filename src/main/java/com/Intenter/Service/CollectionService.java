package com.Intenter.Service;

import com.Intenter.Mapper.CollectionMapper;
import com.Intenter.Mapper.CollectionidUseridMapper;
import com.Intenter.Pojo.Collection;
import com.Intenter.Pojo.CollectionidUserid;
import com.Intenter.config.IdWorker;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private CollectionidUseridMapper collectionidUseridMapper;

    @Autowired
    private IdWorker idWorkcer;


    /**
     * 插入
     * @param collection
     * @return
     */
    public Integer save(Collection collection) {
        //保存
        long id = idWorkcer.nextId();
        System.out.println(id);
        collection.setId(id);

        int i = collectionMapper.insert(collection);
        if (i==0){
            return i;
        }else {
            //获取collectionin
            //写入关联表CollectionidUserid
            CollectionidUserid collectionidUserid = new CollectionidUserid();
            collectionidUserid.setCollectionid(id);
            collectionidUserid.setUserid(collection.getUserid());
            int insert = collectionidUseridMapper.insert(collectionidUserid);
            return insert;
        }
    }

    /**
     * 删除活动
     * @param collectionid
     * @return int
     */
    public Integer delete(Long collectionid) {
        int i = collectionMapper.deleteById(collectionid);
        if (i==0){
            return 0;
        }else {
            //删除相关活动用户
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("collectionid",collectionid);
            int delete = collectionidUseridMapper.delete(wrapper);
            return delete;
        }
    }

    /**
     * 查询state=0的发布的活动
     * @return List<Collection>
     */
    public IPage<Collection> findAllState0(Integer current,Integer size) {
        Page<Collection> Page = new Page(current, size);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state", 0);
        IPage<Collection> iPage = collectionMapper.selectPage(Page, wrapper);
        return iPage;
    }

    /**
     * 查询state=1结束的活动
     * @return List<Collection>
     */
    public List<Collection> findAllState1() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state", 1);
        List<Collection> collections = collectionMapper.selectList(wrapper);

        return collections;
    }

    /**
     * 根据id查询活动
     * @param collectionid
     * @return Collection
     */
    public Collection  findById(Long collectionid) {
        Collection collection = collectionMapper.selectById(collectionid);
        return collection;
    }

    /**
     *查询参与活动的用户id
     * @param collectionid
     * @return List<CollectionidUserid>
     */
    public List<CollectionidUserid> findByCollectionId(Long collectionid){
        HashMap<String, Object> map = new HashMap<>();
        map.put("collectionid", collectionid);
        List<CollectionidUserid> list = collectionidUseridMapper.selectByMap(map);
        return list;

    }

    /**
     * 加入活动
     * @param collectionId
     * @param userId
     * @return
     */
    public Integer TakeOffCollection(Long collectionId, Long userId) {
        CollectionidUserid add = new CollectionidUserid(collectionId, userId);
        int i = collectionidUseridMapper.insert(add);
        return i;

    }
    /**
     * 退出活动
     * @param collectionId
     * @param userId
     * @return
     */
    public Integer quitCollection(Long collectionId, Long userId) {
        QueryWrapper<CollectionidUserid> wrapper = new QueryWrapper<>();
        wrapper.eq("collectionId", collectionId)
                .eq("userId", userId);
        int i = collectionidUseridMapper.delete(wrapper);
        return i;
    }

    /**
     * 查询用户参加活动
     * @param userId
     * @return List<Collection>
     */
    public List<Collection> findCollectionByUserId(Long userId) {
        //查询用户参加活动的id
        QueryWrapper<CollectionidUserid> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId );
        List<CollectionidUserid> collectionidUserids = collectionidUseridMapper.selectList(wrapper);
        ArrayList<Collection> list = new ArrayList<>();
        for (CollectionidUserid collectionidUserid:collectionidUserids
             ) {
            //查询获取详情
            Collection collection = collectionMapper.selectById(collectionidUserid.getCollectionid());
            list.add(collection);
        }
        return list;
    }
    /**
     * 结束活动
     * @param collectionId
     * @return i
     */
    public Integer endCollection(Long collectionId) {
        Integer i= collectionMapper.updateState(collectionId);
        return i;
    }


}
