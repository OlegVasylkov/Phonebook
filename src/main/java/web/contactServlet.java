package web;

import Unit.ContactUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ContactServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("get all contacts");
        request.setAttribute("contactList", ContactUnit.contacts);
        request.getRequestDispatcher("/contactList.jsp").forward(request, response);
    }
}
