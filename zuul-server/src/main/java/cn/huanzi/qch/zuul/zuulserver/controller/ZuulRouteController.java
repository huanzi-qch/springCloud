package cn.huanzi.qch.zuul.zuulserver.controller;

import cn.huanzi.qch.zuul.zuulserver.config.ZuulRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZuulRouteController {

    @Autowired
    ZuulRouteLocator zuulRouteLocator;

    /**
     * 读取数据库zuul表，刷新zuul路由
     */
    @GetMapping("/zuulRouteRefresh")
    public List<Route> zuulRouteRefresh(){
        return zuulRouteLocator.refreshRoutes();
    }

}
