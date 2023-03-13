package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class studentServlet extends HttpServlet {
	
	private List<Student> list = new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list.add(new Student(1, "Hoang Nhu Son", "hoangnhusson3009@gmail.com", "0383551537", 0));
		list.add(new Student(2, "Pham Truong Son", "sonpt19600@gmail.com", "0383551537", 0));
		list.add(new Student(3, "Nguyen Van An", "annv19877@gmail.com", "0383551537", 1));
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/students.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
