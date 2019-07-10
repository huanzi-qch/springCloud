package cn.huanzi.qch.servicea.feign;

import cn.huanzi.qch.servicea.pojo.TbDescription;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-b", path = "/",fallbackFactory = BFeignFallbackFactory.class)
public interface BFeign {
    //负载均衡测试
    @RequestMapping("ribbon")
    public String ribbon();

    //分布式事务测试
    @RequestMapping("txlcn")
    public TbDescription txlcn(@RequestBody Integer userId);
}

/**
 * BFeign熔断降级
 */
@Component
class BFeignFallbackFactory implements FallbackFactory<BFeign> {

    @Override
    public BFeign create(Throwable cause) {
        //打印异常
        System.err.println(cause.getMessage());

        //容错处理
        return new BFeign() {

            @Override
            public String ribbon() {
                return "调用service-b失败";
            }

            @Override
            public TbDescription txlcn(Integer userId) {
                return new TbDescription();
            }
        };
    }
}
