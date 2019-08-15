package cn.mrcode.cache.eshop.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : zhuqiang
 * @date : 2019/8/15 22:56
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    // 过滤器类型 pre，routing，post，error
    @Override
    public String filterType() {
        return "pre";
    }

    // 顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 根据逻辑判断是否要过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object userId = request.getParameter("userId");

        // 不携带 userId 这个参数就表示为未登陆
        if (userId == null) {
            logger.warn("userId is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("userId is empty");
            } catch (Exception e) {
            }

            return null;
        }

        logger.info("ok");

        return null;
    }
}
