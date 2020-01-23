package ash.servlet.analysis.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hi there!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        out.println("<h1> filterApplied: " + request.getAttribute("filterApplied") + "</h1>");
//        out.println("<h1> requestURI: " + request.getAttribute("requestURI") + "</h1>");
//        out.println("<h1> queryString: " + request.getAttribute("queryString") + "</h1>");

        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Submit Form</title>");
        out.println("        <meta name=\"referrer\" content=\"origin\"/>");
        out.println("        <meta http-equiv=\"x-ua-compatible\" content=\"IE=edge\" />");
        out.println("    </head>");
        out.println("    <body onload=\"javascript:document.forms[0].submit()\">");
        out.println("        <noscript>");
        out.println("            <p>");
        out.println("                <strong>Note:</strong> Since your browser does not support JavaScript, you must press the Resume button once to proceed.");
        out.println("            </p>");
        out.println("        </noscript>");
        out.println("        <form method=\"post\" action=\"https://dev-682402.oktapreview.com/app/elliemaedev682402_sclocssoqa_1/exknmq86cfwp3NDVi0h7/sso/saml\">");
        out.println("            <input type=\"hidden\" name=\"SAMLRequest\" value=\"PHNhbWxwOkF1dGhuUmVxdWVzdCBWZXJzaW9uPSIyLjAiIElEPSJhT1hUOHBJaS51TGpCMi1RNXdwczNkQXZnR0UiIElzc3VlSW5zdGFudD0iMjAxOS0xMS0xNVQyMTozNzo0MC4zNDBaIiB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIj48c2FtbDpJc3N1ZXIgeG1sbnM6c2FtbD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI+aHR0cHM6Ly9xYS5pZHAuZWxsaWVsYWJzLmNvbTwvc2FtbDpJc3N1ZXI+PHNhbWxwOk5hbWVJRFBvbGljeSBBbGxvd0NyZWF0ZT0idHJ1ZSIvPjwvc2FtbHA6QXV0aG5SZXF1ZXN0Pg==\"/>");
        out.println("            <input type=\"hidden\" name=\"RelayState\" value=\"FU6qsOHVezC6AKJBnvl3oeJaoQd762\"/>");
        out.println("            <noscript>");
        out.println("                <input type=\"submit\" value=\"Resume\"/>");
        out.println("            </noscript>");
        out.println("        </form>");
        out.println("    </body>");
        out.println("</html>");
        response.addHeader("TEMP_HEADER", "TEMP_HEADER_VAL");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
