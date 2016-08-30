package ua.vasylkov.phonebook.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.vasylkov.phonebook.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.vasylkov.phonebook.web.contact.ContactRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ContactServlet.class);

    private ConfigurableApplicationContext springContext;
    private ContactRestController controller;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        controller = springContext.getBean(ContactRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            final Contact contact = new Contact(
                    request.getParameter("lastName"),
                    request.getParameter("firstName"),
                    request.getParameter("middleName"),
                    request.getParameter("mobilePhone"),
                    request.getParameter("homePhone"),
                    request.getParameter("address"),
                    request.getParameter("email"));
            if (request.getParameter("id").isEmpty()){
                LOG.info("Create {}", contact);
                controller.create(contact);
            }else {
                LOG.info("Update {}", contact);
                int id = Integer.parseInt(request.getParameter("id"));
                controller.update(contact, id);
            }
            response.sendRedirect("contacts");
        }else if (action.equals("filter")){
            String search = resetParam("search", request);
            request.setAttribute("contactList", controller.getFiltered(search));
            request.getRequestDispatcher("/contactList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            LOG.info("get all contacts");
            request.setAttribute("contactList", controller.getAll());
            request.getRequestDispatcher("/contactList.jsp").forward(request, response);
        }else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            LOG.info("Delete {}", id);
            controller.delete(id);
            response.sendRedirect("contacts");
        }else if (action.equals("create") || action.equals("update")) {
            final Contact contact = action.equals("create") ?
                    new Contact("","","","","","","") :
                    controller.get(Integer.parseInt(request.getParameter("id"))); //update
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("editContact.jsp").forward(request, response);
        }
    }

    private String resetParam(String param, HttpServletRequest request){
        String value = request.getParameter(param);
        request.setAttribute(param, value);
        return value;
    }
}