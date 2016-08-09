package ua.vasylkov.phonebook.web;

import ua.vasylkov.phonebook.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.vasylkov.phonebook.repository.ContactRepository;
import ua.vasylkov.phonebook.repository.mock.InMemoryContactRepositoryImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ContactServlet.class);
    private ContactRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryContactRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Contact contact = new Contact(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("lastName"),
                request.getParameter("firstName"),
                request.getParameter("middleName"),
                request.getParameter("mobilePhone"),
                request.getParameter("homePhone"),
                request.getParameter("address"),
                request.getParameter("email"));
        LOG.info(contact.isNew() ? "Create {}" : "Update {}", contact);
        repository.save(contact);
        response.sendRedirect("contacts");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            LOG.info("get all contacts");
            request.setAttribute("contactList", repository.getAll());
            request.getRequestDispatcher("/contactList.jsp").forward(request, response);
        }else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            LOG.info("Delete {}", id);
            repository.delete(id);
            response.sendRedirect("contacts");
        }else if (action.equals("create") || action.equals("update")) {
            final Contact contact = action.equals("create") ?
                    new Contact("","","","","","","") :
                    repository.get(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("editContact.jsp").forward(request, response);
        }
    }
}
