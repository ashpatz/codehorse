package ash.servlet.analysis.web.controller.filters;

import ash.servlet.analysis.web.controller.models.RequestType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class RequestTypeFilter implements Filter {

    private static final String AUTH_ENDPOINT_REGEX = "^/as/authorization\\.oauth2$";
    private static final String RESUME_AUTH_ENDPOINT_REGEX = "^/as/([\\w-]+)/resume/as/authorization\\.ping$";
    private Pattern AUTH_ENDPOINT = Pattern.compile(AUTH_ENDPOINT_REGEX);
    private Pattern RESUME_AUTH_ENDPOINT = Pattern.compile(RESUME_AUTH_ENDPOINT_REGEX);

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
        final String requestURI = httpServletRequest.getRequestURI();
        if(AUTH_ENDPOINT.matcher(requestURI).matches()) {
            request.setAttribute("requestType", RequestType.AUTH);
        } else if(RESUME_AUTH_ENDPOINT.matcher(requestURI).matches()) {
            request.setAttribute("requestType", RequestType.RESUME_AUTH);
        }
        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
