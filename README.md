<div align="center"><img width="200" src="https://codechina.csdn.net/uploads/-/system/group/avatar/506885/logo_196.png?width=72"/>
<h1> 旖旎教育(后端) </h1>

简体中文 |  [English](./README.en.md)

<p>
本项目为广大渴望学习日语的用户提供方便的学习工具为目的的基础上建立的移动应用项目。
</p>
</div>

[![star](https://gitee.com/chu1204505056/vue-admin-beautiful/badge/star.svg?theme=gray)](https://gitee.com/beautiful-japanese/backend-spring-boot)

## 相关项目仓库

| 名称                                                                                        | 简介                                                   |
| -------------------------------------------------------------------------------------------|-------------------------------------------------------|
| [🚀 前端](https://codechina.csdn.net/yi-ni-ri-yu/ri_yu_xue_xi_bao_dian/-/tree/master)    |    Uni-App项目   |
| [🎉 前端](https://gitee.com/beautiful-japanese/japanese-learning-app)     |    Android原声太APP（纯Kotlin编写)                                                         |
| [📌 后端](https://gitee.com/beautiful-japanese/back-end-of-japanese-learning)    |    Go语言Gin-Gonic框架实现的版本   |
| [⚡ 后台管理](https://gitee.com/beautiful-japanese/japanese-learning-background-management)     |    前端-纯Vue                                                         |
| [🌐 后台管理](https://gitee.com/beautiful-japanese/beautiful-Japanese-admin-django)     |   Django-SimpleUI                                                      |

## 分支

| 名称                                                                                   | 简介                                                   |
| --------------------------------------------------------------------------------------|-------------------------------------------------------|
| [🚀 master](https://gitee.com/beautiful-japanese/backend-spring-boot/tree/master/)    | 目前默认版本 （稳定版）  |
| [⚡ develop](https://gitee.com/beautiful-japanese/backend-spring-boot/tree/develop/)   | 开发版本（Beta版）                                                      |

## 原型和UI设计稿

<table>
    <tr><td>访问地址</td><td><a href="https://lanhuapp.com/url/MH7iz">蓝湖</a></td></tr>
    <tr><td>分享人</td><td>1903249375</td></tr>
    <tr><td> 蓝湖团队</td><td>@Sadam</tr>
    <tr><td>相关项目</td><td>旖旎日语</td></tr>
    <tr><td>链接有效期</td><td>20211127~20211211</td></tr>
    <tr><td>密码</td><td>7IG4</td></tr>
</table>

## 🌱 运行JAR包命令

```bash
# 直接console运行
java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k ./jpl-1.0.6.jar
# 后台运行
nohup java -jar -Xms512m -Xmx512m -Xmn200m -Xss256k jpl-1.0.6.jar --spring.profiles.active=prod > jpl-1.0.6.0.log 2>&1 & echo $! > jpl.pid
```

### 参数意义：

<table>
    <tr>
        <td>-XX:MetaspaceSize=128m</td>
        <td>元空间默认大小</td>
    </tr>
    <tr>
        <td>-XX:MaxMetaspaceSize=128m</td>
        <td>元空间最大大小</td>
    </tr>
    <tr>
        <td>-Xms1024m</td>
        <td>堆最大大小</td>
    </tr>
    <tr>
        <td>-Xmx1024m</td>
        <td>堆默认大小</td>
    </tr>
    <tr>
        <td>-Xmn256m：新生代大小</td>
        <td>元空间默认大小</td>
    </tr>
    <tr>
        <td>-Xss256k：栈最大深度大小</td>
        <td>元空间默认大小</td>
    </tr>
    <tr>
        <td>-XX:SurvivorRatio=8：新生代分区比例 8:2</td>
        <td>元空间默认大小</td>
    </tr>
    <tr>
        <td>-XX:+UseConcMarkSweepGC：指定使用的垃圾收集器，这里使用CMS收集器</td>
        <td>元空间默认大小</td>
    </tr>
    <tr>
        <td>-XX:+PrintGCDetails：打印详细的GC日志</td>
        <td>元空间默认大小</td>
    </tr>
</table>

## 我们承诺将定期赞助的开源项目（感谢巨人）

<a title="SpringBoot" href="https://spring.io/" target="_blank">
<img width="200" height="100" src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg"/>
</a>
<a title="Swagger" href="https://swagger.io/" target="_blank">
<img width="200" height="100" src="https://static1.smartbear.co/swagger/media/assets/images/swagger_logo.svg"/>
</a>
<a title="ElasticSearch" href="https://www.elastic.co/cn/" target="_blank">
<img width="200" height="100" src="https://images.contentstack.io/v3/assets/bltefdd0b53724fa2ce/blt280217a63b82a734/5bbdaacf63ed239936a7dd56/elastic-logo.svg"/>
</a>
<a title="Redis" href="https://redis.io/" target="_blank">
<img width="200" height="100" src="https://redis.io/images/redis-white.png"/>
</a>

## 杰出贡献者

<table>
<tr>
<td>

**奇旖旎**

教授

项目总负责人

指导教师
</td>

<td>
<a href="https://gitee.com/sadam98" target="_blank">
  <img width="50px" style="border-radius:999px" src="https://portrait.gitee.com/uploads/avatars/user/1882/5648408_sadam98_1580052770.png!avatar200"/>
萨达木·沙地克
</a>

1903249375@qq.com

项目技术总负责人
</td>
</tr>
</table>

开发团队主要来自于**北京邮电大学**的一群意气蓬勃的大学生。

## 联系我们

- 如果有有关项目的什么问题，可以随时联系我们。
- 联系QQ： 1903249375
- 联系微信：sadam190
- 电话：15899198230

<table>
<tr>
<td>
<img width="200px" src="http://59.110.225.84/static/img/qqGroupChatQR_Code.jpg">
</td>
</tr>
</table>

## 友情链接

- [官网](http://59.110.225.84/)
- [Uniapp插件市场](https://ext.dcloud.net.cn/)
- [Uniapp跨端兼容-条件编译（文档）](https://uniapp.dcloud.io/platform?id=%e8%b7%a8%e7%ab%af%e5%85%bc%e5%ae%b9)
- [Gitee旖旎日语](https://gitee.com/organizations/beautiful-japanese/projects)
