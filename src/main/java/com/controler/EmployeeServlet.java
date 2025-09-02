package com.controler;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeDAO dao = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            default:
                listEmployees(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "insert"; // default

        switch (action) {
            case "insert":
                insertEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/employees");
                break;
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> list = dao.getAllEmployees();
        request.setAttribute("employees", list);
        request.getRequestDispatcher("employee-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("employee", new Employee());
        request.setAttribute("formAction", "insert");
        request.getRequestDispatcher("employee-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee emp = dao.getEmployeeById(id);
        request.setAttribute("employee", emp);
        request.setAttribute("formAction", "update");
        request.getRequestDispatcher("employee-form.jsp").forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Employee emp = new Employee();
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        dao.addEmployee(emp);
        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Employee emp = new Employee();
        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        dao.updateEmployee(emp);
        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteEmployee(id);
        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
