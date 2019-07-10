package cn.huanzi.qch.servicec.controller;

import cn.huanzi.qch.servicec.pojo.TbDescription;
import cn.huanzi.qch.servicec.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("feign")
    public String feign() {
        return "我是" + applicationName + "，我的端口是" + serverPort;
    }

    @RequestMapping("txlcn")
    public TbDescription txlcn(@RequestBody Integer userId){
        return testService.txlcn(userId);
    }
}
