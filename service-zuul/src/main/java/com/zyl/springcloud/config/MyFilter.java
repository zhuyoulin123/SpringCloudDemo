package com.zyl.springcloud.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuyoulin
 * @program minespringcloudpro
 * @description 配置安全验证，过滤规则等
 * @create 2020-10-09 15:52
 **/
@Component
public class MyFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型, 在zuul中定义了四种不同生命周期的过滤器类型, 具体如下:
     * pre: 路由之前
     * routing: 路由之时
     * post: 路由之后
     * error: 发送错误调用
     **/
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断, 是否要过滤, 文本true为永远过滤
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑, 可用很复杂, 包括查SQL, NoSQL去判断请求到底有没有访问权限
     **/
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOG.info(String.format("%s > > > %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            LOG.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                return null;
            }
        }
        LOG.info("ok");
        return null;
    }
}
