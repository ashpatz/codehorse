package ash.servlet.analysis.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        out.println("<h1> filterApplied: " + request.getAttribute("filterApplied") + "</h1>");
        out.println("<h1> requestURI: " + request.getAttribute("requestURI") + "</h1>");
        out.println("<h1> queryString: " + request.getAttribute("queryString") + "</h1>");
    }
}
