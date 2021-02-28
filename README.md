# MyApplication
## 包含handler各种实例
参考 Android网络操作与流行框架
   1 子线程通知主线程
   2 异步任务
   3 文件下载进度条
   4 倒计时
## 网络操作各种实例
参考 Android网络操作与流行框架
    1

## AsyncTask异步任务各种实例

## 列表  listview  [ListViewActivity.java](app/src/main/java/com/example/administrator/myapplication/list/ListViewActivity.java)
 1 添加图片展示
 2 点击加载详情

# io http
##  okio 实例  （ [ExampleUnitTest.java](app/src/test/java/com/example/administrator/myapplication/ExampleUnitTest.java)）
## okhttp 实例  [OkhttpActivity.java](app/src/main/java/com/example/administrator/myapplication/http/OkhttpActivity.java)

# eventbus  通信   事件总线  订阅发送
## 1常规通信方法
[EventSimpleActivity.java](app/src/main/java/com/example/administrator/myapplication/event/EventSimpleActivity.java)
通过实现接口的方式实现对上层服务操作的监听
缺点：耦合性比较强

## 本地广播监听
[EventLocalListenerActivity.java](app/src/main/java/com/example/administrator/myapplication/event/EventLocalListenerActivity.java)
通过注册本地广播进行监听组建的变化

## 使用组件监听evenbus 通信方法


