package cn.huanzi.qch.servicea.controller;

import cn.huanzi.qch.servicea.feign.BFeign;
import cn.huanzi.qch.servicea.feign.CFeign;
import cn.huanzi.qch.servicea.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private BFeign bFeign;

    @Autowired
    private CFeign cFeign;

    @RequestMapping("ribbon")
    public String ribbon(){
        return bFeign.ribbon();
    }

    @RequestMapping("feign")
    public String feign(){
        return cFeign.feign();
    }

    @RequestMapping("txlcn")
    public String txlcn(String exFlag){
        return testService.txlcn(exFlag);
    }
}
