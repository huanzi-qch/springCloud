package cn.huanzi.qch.zuul.zuulserver.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 自定义zuul路由
 */
@Component
public class ZuulRouteLocator implements InitializingBean {

    @Autowired
    private CompositeRouteLocator compositeRouteLocator;

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 刷新zuul路由
     *
     * 数据来源：
     *      配置文件
     *      数据库zuul路由表
     */
    public List<Route> refreshRoutes() {
        //读取原配置文件的路由配置
        Map<String, ZuulRoute> routes = zuulProperties.getRoutes();

        //读取数据库zuul路由表配置
       List<ZuulRoute> routeList = jdbcTemplate.query("select id,service_id,path from zuul_route", new BeanPropertyRowMapper<>(ZuulRoute.class));

        //routeList数据并添加到routes中
        for (ZuulRoute route : routeList) {
            routes.put(route.getId(), route);
        }

        //刷新zuul路由
        zuulProperties.setRoutes(routes);
        compositeRouteLocator.refresh();

        //返回现有路由
        return compositeRouteLocator.getRoutes();
    }

    /**
     * 初始化路由信息
     */
    @Override
    public void afterPropertiesSet() {
        this.refreshRoutes();
    }
}
