# XPU_COS_微服务版

#### 介绍
xpu 软件工程2002班第一组 客户订购系统 在线仓库<br/>

#### 软件架构
软件架构说明

前后端分离项目，采用分布式架构<br/>
前端使用vue框架<br/>
后端使用SpringCloud微服务框架开发<br/>
主要技术有
SpringCloud+SpringBoot+MybatisPlus+Redis
使用redis实现了微服务session共享，与订单管理服务的缓存处理（高并发场景）
#### 安装教程
基本环境搭建
1.  安装nacos 2.2
2.  安装mysql 8.0+, jdk 1.8
3.  安装redis 3.2.100
4.  安装Node.js v16.18.1
5.  安装IDEA编辑器,集成maven3.6.1
#### 使用说明

1.  修改各服务中redis配置，在各自yml配置文件中
2.  修改各服务中Druid  mysql数据库连接池配置，在各自yml配置文件中
3.  启动 mysql  redis nacos服务
4.  maven将源码打包成jar包后  在命令行执行<br/> java -jar  jar包名    <br/>运行后端
5.  进入前端项目目录xpu-cos-ui中命令行执行<br/>npm install <br/> npm run dev <br/>运行前端
#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
