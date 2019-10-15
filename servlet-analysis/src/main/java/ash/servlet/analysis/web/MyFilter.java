package ash.servlet.analysis.web;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("filterApplied", "yes indeed");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
