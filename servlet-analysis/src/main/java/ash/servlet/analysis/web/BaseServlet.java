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
        final Object filterApplied = request.getAttribute("filterApplied");
        System.out.println("Filter Applied:: "+filterApplied);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        final String requestURI = request.getRequestURI();
        out.println("<h1>" + requestURI + "</h1>");
    }
}
