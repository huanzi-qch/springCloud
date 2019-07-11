SpringCloud系列Demo代码<br/>

SpringCloud的Demo代码包括了一下分布式的基本组件，具体请看博客、代码<br/>

版本用的是2.1.0.RC3，在pom文件引入的是<br/>
```XML
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
```
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

具体介绍请看我的博客[《SpringCloud系列》](https://www.cnblogs.com/huanzi-qch/category/1364332.html)<br/> 
