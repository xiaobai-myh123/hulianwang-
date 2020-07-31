>#**接口说明**
>>##普通用户接口User
>>>###登录：  
>>>>url:   localhost:8081/User/login  
>>>param:   
    String userName  
    String passWord  
>return: user  
>>>###用户注册：
>>>>url:   localhost:8081/User/save 
>>>param:   
    User {
           "username": "demoData",
           "password": "demoData",
           "phone": "demoData",
           "state": 1,
           "name": "demoData",
           "stop": 1
         }  
>json格式对象id自动生成 state 0:普通用户，1：解答师 stop 0：启用 1：禁用   
>return: Integer 
>>>###用户修改：
>>>>url:   localhost:8081/User/update 
>>>param:   
    User {
           "id" : 1
           "username": "demoData",
           "password": "demoData",
           "phone": "demoData",
           "state": 1,
           "name": "demoData",
           "stop": 1
         }  
>json格式对象 只能修改password字段和name字段和phone字端  
>return: Integer  
>>>###删除：  
>>>>url:   localhost:8081/User/delete
>>>param:   
    Long id  
>return: Integer    

>>##募捐接口Collection 
>>>###插入 
 >>>>url:   localhost:8081/collection/save  
 >>>param:   
     Collection {
            "userid": 1,
            "username": "demoData",
            "name": "demoData",
            "departaddr": "demoData",
            "destinationaddr": "demoData",
            "endtime": "2020-7-31 9:40:00",
            "state": 1,
            "text": "demoData"
          } 
 >json格式对象 state 0：活动开始 1：活动结束   
 >return: Integer  
>>>###删除：  
 >>>>url:   localhost:8081/collection/delete
 >>>param:   
     Long collectionid   
 >return: Integer  
>>>###查询所有正在进行的活动：  
 >>>>url:   localhost:8081/collection/findAllState0 
 >>>param:   
 Long current  第几页默认 1
 Long size   每页多少条默认 10  
 >return: Ipage对象 
>>>###查询所有已结束的活动：  
 >>>>url:   localhost:8081/collection/findAllState1  
 >return List<Collection>  
>>>###根据id查询活动：  
 >>>>url:   localhost:8081/collection/findById
 >>>param:   
     Long collectionid  
 >return: collectionUser
>>>###参加活动：  
 >>>>url:   localhost:8081/collection/takeOffCollection
 >>>param:   
     Long collectionId  
     Long userId  
 >return: Integer
>>>###退出活动：  
 >>>>url:   localhost:8081/collection/quitCollection
 >>>param:   
     Long collectionId  
     Long userId  
 >return: Integer
>>>###查询用户的所有活动：  
  >>>>url:   localhost:8081/collection/findCollectionByUserId  
  >>>param:   
      Long userId  
  >return: Integer
>>>###结束活动：  
 >>>>url:   localhost:8081/collection/endCollection  
 >>>param:   
     Long collectionId  
 >return: List<Collection>
>>##管理员用户接口User
>>>###登录：  
>>>>url:   localhost:8081/admin/login  
>>>param:   
String userName  
String passWord  
>return: admin  
>>>###用户注册：
>>>>url:   localhost:8081/admin/save 
>>>param:   
    Admin {
           "username": "demoData",
           "password": "demoData",
           "phone": "demoData",
           "name": "demoData",
         }    
>json格式对象id自动生成  
>return: Integer 
>>>###用户修改：
>>>>url:   localhost:8081/admin/update  
>>>param:   
    Admin {
           "id" : 1
           "username": "demoData",
           "password": "demoData",
           "phone": "demoData",
           "name": "demoData",
         }  
>json格式对象 只能修改password字段和name字段和phone字端  
>return: Integer  
>>>###删除：  
>>>>url:   localhost:8081/admin/delete  
>>>param:   
    Long id  
>return: Integer 
>>>###停用和启用：  
 >>>>url:   localhost:8081/admin/updateStop  
 >>>param:   
     Long userId  
     Long stop  
 >return: Integer 
>>>###查询所有用户：  
 >>>>url:   localhost:8081/admin/findAll   
 >>>param:   
 Long current  第几页默认 1  
 Long size   每页多少条默认 10  
 >return: Ipage对象 