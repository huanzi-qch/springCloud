## 官网<br/> 
https://huanzi-qch.gitee.io/spring-cloud <br/>

## 简介<br/> 
SpringCloud系列Demo代码<br/>

SpringCloud的Demo代码包括了一下分布式的基本组件，具体请看博客、代码<br/>
父项目是一个maven项目，继承spring-boot-starter-parent，引入spring-cloud依赖管理，同时引入了部分公用依赖<br/>
```xml
    <!--  父类继承spring-boot-starter-parent  -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.0.RELEASE</version>
        <relativePath/>
    </parent>
    
    <!-- 引入spring-cloud依赖管理 -->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Greenwich.RC1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <!-- 在父类引入一下通用的依赖 -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Greenwich.RC1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <!-- spring-boot-starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- springboot web(MVC)-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- springboot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- actuator -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!--lombok插件 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!--热部署工具dev-tools-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

    <!-- 仓库地址 -->
    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
        </repository>
    </repositories>
```
<br/>

每个子项目都是一个独立的SpringBoot项目，子项目直接继承父类<br/>
```xml
    <!--继承父类-->
    <parent>
        <groupId>cn.huanzi.qch</groupId>
        <artifactId>parent</artifactId>
        <version>1.0.0</version>
    </parent>
```
<br/>

每个子项目都是SpringCloud的一个知识点或者说技能点，具体见名思意！具体介绍都有对应的博客，详情请看下方的“前往博客查看详情”<br/>
SpringCloud代码跟之前写博客时有所改动，现在的项目命名更加规范，比较利于理解<br/>

改动后测试例子：<br/>
PS：由于图片是引入我博客里面的图片，有时会出现显示不出来的问题，可以直接前往[博客](https://www.cnblogs.com/huanzi-qch/p/11159140.html)-->点击目录：SpringCloud系列，即可查看效果图

eureka注册<br/>
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709170203512-1989174003.png) 

sso单点登录<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709170008526-1381439397.gif) 

令牌桶限流<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709170057856-1397716464.gif) 

feign调用<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165652766-1586827349.gif)

ribbon负载均衡<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165552510-1499987972.gif) 

txlcn分布式事务<br/>

事务回滚<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165117179-486526496.png) 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165132414-1135074209.png) ![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165149126-1885715595.png) 

事务提交<br/> 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165254205-1928376649.png) 
![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165402681-578160074.png) ![](https://img2018.cnblogs.com/blog/1353055/201907/1353055-20190709165422311-1515700953.png) 

## 仓库地址<br/> 
国外：https://github.com/huanzi-qch/springCloud<br/> 
国内：https://gitee.com/huanzi-qch/springCloud<br/> 

## 前往博客查看详情<br/> 
具体介绍请看我的博客[《SpringCloud系列》](https://www.cnblogs.com/huanzi-qch/category/1364332.html)<br/> 

| 项目 | 博客 |
|  ----  | ----  |
| config-server | [SpringCloud系列——Config 配置中心](https://www.cnblogs.com/huanzi-qch/p/10149547.html) <br/> [SpringCloud系列——Bus 消息总线](https://www.cnblogs.com/huanzi-qch/p/10155091.html) |
| eureka-server | [SpringCloud系列——Eureka 服务注册与发现](https://www.cnblogs.com/huanzi-qch/p/10131985.html) |
| sso-server | [SpringCloud系列——SSO 单点登录](https://www.cnblogs.com/huanzi-qch/p/10249227.html) |
| txlcn-tm | [SpringCloud系列——TX-LCN分布式事务管理](https://www.cnblogs.com/huanzi-qch/p/11057974.html) |
| zuul-server | [SpringCloud系列——Zuul 动态路由](https://www.cnblogs.com/huanzi-qch/p/10142395.html) |
| server-a <br/> server-b1/b2 <br/> server-c | [SpringCloud系列——Feign 服务调用](https://www.cnblogs.com/huanzi-qch/p/10135946.html) |
| server-b1/b2 | [SpringCloud系列——Ribbon 负载均衡](https://www.cnblogs.com/huanzi-qch/p/10136254.html) |

## AD广告位（长期招租，如有需要请私信）<br/> 
[【基塔后台】免费后台管理系统，低代码快速搭建管理后台](https://www.jeata.com/?hmsr=promotion&hmpl=huanzi-qch) <br/>
<br/>
[【腾讯云】云产品限时秒杀，爆款1核2G云服务器，首年74元！](https://cloud.tencent.com/act/cps/redirect?redirect=1077&cps_key=e1c9db729edccd479fc902634492bf53&from=console) <br/>
[【腾讯云】境外1核2G服务器低至2折，半价续费券限量免费领取！](https://cloud.tencent.com/act/cps/redirect?redirect=1068&cps_key=e1c9db729edccd479fc902634492bf53&from=console) <br/>
[【腾讯云】星星海SA2云服务器，1核2G首年99元起，高性价比首选！](https://cloud.tencent.com/act/cps/redirect?redirect=1063&cps_key=e1c9db729edccd479fc902634492bf53&from=console) <br/>
[【腾讯云】中小企业福利专场，多款刚需产品，满足企业通用场景需求，云服务器2.5折起！](https://cloud.tencent.com/act/cps/redirect?redirect=1060&cps_key=e1c9db729edccd479fc902634492bf53&from=console) <br/>  
<br/>
[【阿里云】新老用户同享，上云优化聚集地！](https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=ckkryd9h&utm_source=ckkryd9h) <br/>
[【阿里云】最新活动页，上新必买抢先知，劲爆优惠不错过！](https://www.aliyun.com/activity?userCode=ckkryd9h) <br/>
[【阿里云】轻量应用服务器2核2G 低至60元/年起！香港与海外服务器最低24元/月起！](https://www.aliyun.com/daily-act/ecs/activity_selection?userCode=ckkryd9h) <br/>
[【阿里云】ECS实例升级、续费，享低至 6.3折 限时折扣！](https://www.aliyun.com/daily-act/ecs/care?userCode=ckkryd9h) <br/>
<br/>

## QQ群<br/>
有事请加群，有问题进群大家一起交流！
QQ群名：Java交流群-huanzi-qch
QQ群号：1015379123
![](http://huanzi-qch.gitee.io/file-server/images/qq.png) 
<br/>注：如果图片加载不出来请点击查看[这里](http://huanzi-qch.gitee.io/file-server/images/qq.png)

## 捐献<br/>
相应的资金支持能更好的持续项目的维护和开发，如果喜欢这个项目，请随意打赏！

| 支付宝 | 微信 |
|  ----  | ----  |
| <img src="http://huanzi-qch.gitee.io/file-server/images/zhifubao.png"  width="150"> | <img src="http://huanzi-qch.gitee.io/file-server/images/weixin.png" width="150"> |


## 学习资料<br/>
Spring全家桶的GitHub：https://github.com/spring-projects <br/>
SpringCloud官方文档：https://spring.io/projects/spring-cloud <br/>
SpringCloud官方GitHub：https://github.com/spring-cloud <br/>

这些资料有丰富的文档介绍、代码示例 <br/>
