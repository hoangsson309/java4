package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChucVu;
import service.iml.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "Servlet", value = {
		"/chuc-vu/hien-thi",
		"/chuc-vu/add",
		"/chuc-vu/update",
		"/chuc-vu/delete",
		"/chuc-vu/detail"
})
public class Servlet extends HttpServlet {
	
	Service<ChucVu> service = new Service<>(ChucVu.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("hien-thi")){
			this.hienThi(request, response);
		}
		else if (uri.contains("detail")){
			this.detailView(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChucVu> list = service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/viewTest/ChucVuHienThi.jsp").forward(request, response);
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChucVu cv = service.findById(UUID.fromString(request.getParameter("id")));
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/details.jsp").forward(request, response);
	}
}
