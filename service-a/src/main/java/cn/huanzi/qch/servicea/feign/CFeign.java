package cn.huanzi.qch.servicea.feign;

import cn.huanzi.qch.servicea.pojo.TbDescription;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-c", path = "/",fallbackFactory = CFeignFallbackFactory.class)
public interface CFeign {
    //feign调用测试
    @RequestMapping("feign")
    public String feign();

    //分布式事务测试
    @RequestMapping("txlcn")
    public TbDescription txlcn(@RequestBody Integer userId);
}

/**
 * CFeign熔断降级
 */
@Component
class CFeignFallbackFactory implements FallbackFactory<CFeign> {

    @Override
    public CFeign create(Throwable cause) {
        //打印异常
        System.err.println(cause.getMessage());

        //容错处理
        return new CFeign() {

            @Override
            public String feign() {
                return "调用service-c失败";
            }

            @Override
            public TbDescription txlcn(Integer userId) {
                return new TbDescription();
            }
        };
    }
}