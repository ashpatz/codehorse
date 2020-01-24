package ash.servlet.analysis.web.controller.filters;

import ash.servlet.analysis.web.controller.models.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestParamModifyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }

        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        chain.doFilter(new MyRequestWrapper(httpServletRequest), httpServletResponse);
    }

    @Override
    public void destroy() {

    }


    private static class MyRequestWrapper extends HttpServletRequestWrapper {

        public MyRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            if(name.equals(Constants.CUSTOM_PARAM)) {
                return "customValue";
            }
            return super.getParameter(name);
        }
    }
}
