package com.dinner3000.demo.respbody.filter;

import javax.servlet.*;
import java.io.IOException;

public class IOSSpecificProcessFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("IOSSpecificProcessFilter - init()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("IOSSpecificProcessFilter - doFilter() - before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("IOSSpecificProcessFilter - doFilter() - after");
    }

    public void destroy() {
        System.out.println("IOSSpecificProcessFilter - destroy()");
    }
}
