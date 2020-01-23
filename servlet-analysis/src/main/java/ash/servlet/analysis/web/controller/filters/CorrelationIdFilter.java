package ash.servlet.analysis.web.controller.filters;

import static ash.servlet.analysis.web.controller.models.Constants.CORRELATION_ID;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class CorrelationIdFilter implements Filter {

    private static final Logger log
            = LoggerFactory.getLogger(CorrelationIdFilter.class);

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

        final HttpSession session = httpServletRequest.getSession(true);
        String correlationId = ObjectUtils.defaultIfNull(session.getAttribute(CORRELATION_ID), "").toString();
        if (StringUtils.isBlank(correlationId)) {
            correlationId = UUID.randomUUID().toString();
            session.setAttribute(CORRELATION_ID, correlationId);
        }
        MDC.put("correlationId", correlationId);
        chain.doFilter(request, response);
        if (StringUtils.isNotBlank(correlationId)) {
            httpServletResponse.addHeader(CORRELATION_ID, correlationId);
        }

        final String tempHeaderVal = httpServletResponse.getHeader("TEMP_HEADER");
        log.info(" Received temp header {}", tempHeaderVal);
    }

    @Override
    public void destroy() {

    }
}
