package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Student;
import repository.StudentRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet", value = {"/students",
	"/students/add"
})
public class studentServlet extends HttpServlet {
	
	private List<Student> list = new ArrayList<>();
	private StudentRepository repository = new StudentRepository();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		list.add(new Student(1, "Hoang Nhu Son", "hoangnhusson3009@gmail.com", "0383551537", 0));
//		list.add(new Student(2, "Pham Truong Son", "sonpt19600@gmail.com", "0383551537", 0));
//		list.add(new Student(3, "Nguyen Van An", "annv19877@gmail.com", "0383551537", 1));
//
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("/view/students.jsp").forward(request, response);
		
		list = repository.getAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/view/students.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer id = Integer.parseInt(request.getParameter("id"));
//		String fullName = request.getParameter("fullName");
//		String email = request.getParameter("email");
//		String phoneNumber = request.getParameter("phoneNumber");
//		Integer status = Integer.parseInt(request.getParameter("status"));
//		list.add(new Student(id, fullName, email, phoneNumber, status));
//		response.sendRedirect("/students");
	}
}
