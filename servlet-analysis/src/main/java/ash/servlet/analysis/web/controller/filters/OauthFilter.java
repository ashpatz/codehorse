package ash.servlet.analysis.web.controller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A filter that modifies a response must usually capture the response before it is returned to the client.
 * The way to do this is to pass the servlet that generates the response a stand-in stream.
 * The stand-in stream prevents the servlet from closing the original response stream when it completes
 * and allows the filter to modify the servlet's response.
 */
public class OauthFilter implements Filter {

    private static final Logger log
            = LoggerFactory.getLogger(OauthFilter.class);
    private Pattern htmlFormRegex = Pattern.compile("<form");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final PrintWriter writerOriginal = response.getWriter();
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            CharResponseWrapper wrapper = new CharResponseWrapper(httpServletResponse);
            chain.doFilter(request, wrapper);
            if(isSso(wrapper)) {
                log.debug("SSO started");
            }
            writerOriginal.write(wrapper.toString());
        } else {
            chain.doFilter(request, response);
        }

    }

    private boolean isSso(CharResponseWrapper response) {
        final int status = response.getStatus();
        final String contentType = response.getContentType();
        final Matcher matcher = htmlFormRegex.matcher(response.toString());
        if(status == Response.Status.OK.getStatusCode() &&
             contentType.contains(MediaType.TEXT_HTML)  &&
                matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * In order to pass this stand-in stream to the servlet, the filter creates a response "wrapper" that overrides
     * the getWriter or getOutputStream method to return this stand-in stream.
     * The wrapper is passed to the doFilter method of the filter chain
     */
    public class CharResponseWrapper extends HttpServletResponseWrapper {

        private StringWriter output;

        public String toString() {
            return output.toString();
        }
        public CharResponseWrapper(HttpServletResponse response){
            super(response);
            output = new StringWriter();
        }
        public PrintWriter getWriter(){
            return new PrintWriter(output);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
