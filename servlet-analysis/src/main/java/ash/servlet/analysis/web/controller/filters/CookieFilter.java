package ash.servlet.analysis.web.controller.filters;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CookieFilter implements Filter {

    private static final Logger log
            = LoggerFactory.getLogger(CookieFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            final Cookie[] cookies = ObjectUtils.defaultIfNull(httpServletRequest.getCookies(), new Cookie[]{});
            for (Cookie requestCookie : cookies) {
                log.debug("Cookie {} : {}", requestCookie.getName(), requestCookie.getValue());
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
