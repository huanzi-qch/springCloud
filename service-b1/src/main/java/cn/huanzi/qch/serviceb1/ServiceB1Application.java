package cn.huanzi.qch.serviceb1;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//手动加载自定义配置文件
@PropertySource("classpath:datasource.properties")
@PropertySource("classpath:config.properties")
@PropertySource("classpath:eureka.properties")
@PropertySource("classpath:tx-lcn.properties")
@PropertySource("classpath:feign.properties")

@RibbonClient(name = "RibbonConfig", configuration = RibbonConfig.class)
@EnableDistributedTransaction
@RefreshScope
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceB1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceB1Application.class, args);
    }

}

@Configuration
class RibbonConfig {

    @Bean
    public IRule myRibbonRule(){
        return new RandomRule(); //分配策略：随机选择一个server
//        return new BestAvailableRule(); //分配策略：选择一个最小的并发请求的server，逐个考察Server，如果Server被tripped了，则忽略
//        return new RoundRobinRule(); //分配策略：轮询选择，轮询index，选择index对应位置的server
//        return new WeightedResponseTimeRule(); //分配策略：根据响应时间分配一个weight(权重)，响应时间越长，weight越小，被选中的可能性越低
//        return new ZoneAvoidanceRule(); //分配策略：复合判断server所在区域的性能和server的可用性选择server
//        return new RetryRule(); //分配策略：对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        return new ServerListSubsetFilter();
    }
}
