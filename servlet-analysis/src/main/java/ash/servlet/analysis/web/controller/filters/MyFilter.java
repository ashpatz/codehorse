package ash.servlet.analysis.web.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

public class MyFilter implements Filter {

    private static final String AUTH_ENDPOINT_REGEX = "^\\/as\\/authorization\\.oauth2$";
    private static final String RESUME_AUTH_ENDPOINT_REGEX = "^\\/as\\/([\\w-]+)\\/resume\\/as\\/authorization\\.ping$";
    private Pattern AUTH_ENDPOINT;
    private Pattern RESUME_AUTH_ENDPOINT;

    private static final Logger log
            = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        initializeRegexes();
    }

    private void initializeRegexes() {
        AUTH_ENDPOINT = Pattern.compile(AUTH_ENDPOINT_REGEX);
        RESUME_AUTH_ENDPOINT = Pattern.compile(RESUME_AUTH_ENDPOINT_REGEX);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.trace("Entering doFilter");

        if (request instanceof HttpServletRequest) {
            log.info("Received HttpServletRequest");
            String requestURI = ((HttpServletRequest)request).getRequestURI();
            String queryString = ((HttpServletRequest)request).getQueryString();

            request.setAttribute("requestURI", requestURI);
            request.setAttribute("queryString", queryString);
        }

        if (!isRequired(request)) {
            log.debug("Filter not applied");
            chain.doFilter(request, response);
            return;
        }
        log.debug("Filter applied");
        request.setAttribute("filterApplied", "yes");
        chain.doFilter(request, response);
        log.trace("Completed doFilter");
    }

    private boolean isRequired(final ServletRequest request) {
        if (request instanceof HttpServletRequest) {
            String resourcePath = ((HttpServletRequest) request).getRequestURI();
            if (AUTH_ENDPOINT.matcher(resourcePath).matches()) {
                return true;
            }

            if (RESUME_AUTH_ENDPOINT.matcher(resourcePath).matches()) {
                return true;
            }
            return false;
        }
        //TODO: Should we skip the filter if request is not HttpServletRequest
        return true;
    }

    @Override
    public void destroy() {

    }

}
