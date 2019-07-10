package cn.huanzi.qch.zuul.zuulserver.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sso-server", path = "/",/*fallback = SsoFeign.SsoFeignFallback.class,*/fallbackFactory = SsoFeign.SsoFeignFallbackFactory.class)
public interface SsoFeign {
    /**
     * 判断key是否存在
     */
    @RequestMapping("redis/hasKey/{key}")
    public Boolean hasKey(@PathVariable("key") String key);

    /**
     * 容错处理（服务提供者发生异常，将会进入这里）
     */
    @Component
    public class SsoFeignFallback implements SsoFeign {

        @Override
        public Boolean hasKey(String key) {
            System.out.println("调用sso-server失败，进行SsoFeignFallback.hasKey处理：return false;");
            return false;
        }
    }

    /**
     * 只打印异常，容错处理仍交给 SsoFeignFallback
     */
    @Component
    public class SsoFeignFallbackFactory implements FallbackFactory<SsoFeign> {
        private final SsoFeignFallback ssoFeignFallback;

        public SsoFeignFallbackFactory(SsoFeignFallback ssoFeignFallback) {
            this.ssoFeignFallback = ssoFeignFallback;
        }

        @Override
        public SsoFeign create(Throwable cause) {
            cause.printStackTrace();
            return ssoFeignFallback;
        }
    }

    /*public class SsoFeignFallbackFactory implements FallbackFactory<SsoFeign> {

        @Override
        public SsoFeign create(Throwable cause) {
            //打印异常
            cause.printStackTrace();

            return new SsoFeign() {
                @Override
                public Boolean hasKey(String key) {
                    System.out.println("调用sso-server失败：return false;");
                    return false;
                }
            };
        }
    }*/
}