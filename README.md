### 前置准备：

``` 
redis  推荐`5.0.14`(开发中使用)
mysql 推荐5.7
```

### mysql 配置

```
mysql用户名： root

mysql密码：admin
```

### 如何启动 / 运行

#### 后端

进入jar目录，依次执行

``` shell
java -jar qiniu-category.jar
java -jar qiniu-video.jar
java -jar qiuniu-security.jar
```

即可启动服务

#### 前端


前端启动如下

##### 安装依赖包
```bash
npm install
```

##### 运行
```bash
npm run serve
```

经 localhost:8080 访问前端站点

##### 打包

```bash
npm run build
```

#### 项目结构

```
├─qiniu-server								// java后端
│  ├─qiniu-category							// 分类模块
│  ├─qiniu-common							// 引用类
│  ├─qiniu-security							// 登录注册模块
│  └─qiniu-video							// 视频播放及点赞等模块
└─web
    └─Qiniuuu								// Vue前端部分
        ├─public							// 公共资源
        └─src								// 主要代码
            ├─assets
            ├─components					// 组件
            ├─router						// 路由
            ├─store							// 播放功能js
            └─views							// 页面
```



#### 分工等文档地址

##### 项目报告

https://u45brcbfyd.feishu.cn/docx/WSIydoCqyoI7JJx050acJKdMnjG

##### 接口文档

https://apifox.com/apidoc/shared-4586b521-47c1-4368-98bd-fd7dfaa3dc27/api-119961258