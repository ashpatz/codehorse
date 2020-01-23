package ash.servlet.analysis.web.controller.filters;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class FormEncodedBodyReadFilter implements Filter {

    private static final Logger log
            = LoggerFactory.getLogger(FormEncodedBodyReadFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String code = "";
        final String contentType = request.getHeader(HttpHeaders.CONTENT_TYPE);
        if (StringUtils.isNotBlank(contentType) && contentType.equals(MediaType.APPLICATION_FORM_URLENCODED)) {
            code = request.getParameter("code");
            log.info("Received code {}", code);
        }

        if (StringUtils.isNotBlank(code)) {
            response.setHeader("received_auth_code", code);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
