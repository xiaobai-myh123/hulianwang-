package com.Intenter.Controller;

import com.Intenter.Pojo.Collection;
import com.Intenter.Pojo.CollectionUser;
import com.Intenter.Pojo.CollectionidUserid;
import com.Intenter.Pojo.User;
import com.Intenter.Service.CollectionService;
import com.Intenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("collection")
@RestController
public class CollectionController {

    @Autowired
    private CollectionService collectionServer;

    @Autowired
    private UserService userService;

    /**
     *插入
     * @param collection
     * @return i
     */
    @PostMapping("save")
    public ResponseEntity<Integer> save(@RequestBody Collection collection){
        Integer i = collectionServer.save(collection);
        return ResponseEntity.ok(i);
    }

    /**
     *collectionid删除
     * @param collectionid
     * @return i
     */
    @GetMapping("delete")
    public ResponseEntity<Integer> delete(@RequestParam("collectionid") Long collectionid){
        Integer i = collectionServer.delete(collectionid);
        return ResponseEntity.ok(i);
    }

    /**
     *查询所有state=0开始
     * @return list<collection></>
     */
    @GetMapping("findAllState0")
    public ResponseEntity<List<Collection>> findAllState0(
            @RequestParam("current") Integer current,
            @RequestParam("size") Integer size
    ){
        List<Collection> collectionList = collectionServer.findAllState0(current,size);
        return ResponseEntity.ok(collectionList);
    }
    /**
     *查询所有state=1结束
     * @return list<collection></>
     */
    @GetMapping("findAllState1")
    public ResponseEntity<List<Collection>> findAllState1(){
        List<Collection> collectionList = collectionServer.findAllState1();
        return ResponseEntity.ok(collectionList);
    }

    /**
     *根据id查询募捐详情
     * @param collectionid
     * @return CollectionUser
     */
    @GetMapping("findById")
    public ResponseEntity<CollectionUser> findById(@RequestParam("collectionid") Long collectionid){
        Collection collection = collectionServer.findById(collectionid);
        List<CollectionidUserid> usersId = collectionServer.findByCollectionId(collectionid);

        ArrayList<User> userList = new ArrayList<>();

        for (CollectionidUserid userid: usersId) {
            User user = userService.findById(userid.getUserid());
            userList.add(user);
        }
        CollectionUser collectionUser = new CollectionUser();
        collectionUser.setCollection(collection);
        collectionUser.setUsers(userList);

        return ResponseEntity.ok(collectionUser);
    }

    /**
     * 加入活动团队
     * @param collectionId
     * @param userId
     * @return
     */
    @PostMapping("takeOffCollection")
    public ResponseEntity<Integer> takeOffCollection(@RequestParam("collectionId") Long collectionId,@RequestParam("userId") Long userId){
        Integer i= collectionServer.TakeOffCollection(collectionId,userId);
        return ResponseEntity.ok(i);
    }
    /**
     * 退出活动团队
     * @param collectionId
     * @param userId
     * @return
     */
    @PostMapping("quitCollection")
    public ResponseEntity<Integer> quitCollection(@RequestParam("collectionId") Long collectionId,@RequestParam("userId") Long userId){
        Integer i= collectionServer.quitCollection(collectionId,userId);
        return ResponseEntity.ok(i);
    }

    /**
     * 查询用户参加活动
     * @param userId
     * @return List<Collection>
     */
    @GetMapping("findCollectionByUserId")
    public ResponseEntity<List<Collection>> findCollectionByUserId(@RequestParam("userId") Long userId){
        List<Collection> collectionList=collectionServer.findCollectionByUserId(userId);
        return ResponseEntity.ok(collectionList);
    }



    /**
     * 结束活动
     * @param collectionId
     * @return i
     */
    @PostMapping("endCollection")
    public ResponseEntity<Integer> endCollection(@RequestParam("collectionId") Long collectionId){
        Integer i= collectionServer.endCollection(collectionId);
        return ResponseEntity.ok(i);
    }



}
