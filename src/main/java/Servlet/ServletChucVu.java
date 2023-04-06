package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChucVu;
import service.iml.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "servletChucVu", value = {
		"/chuc-vu/hien-thi",
		"/chuc-vu/add",
		"/chuc-vu/update",
		"/chuc-vu/delete",
		"/chuc-vu/detail"
})
public class ServletChucVu extends HttpServlet {
	
	Service<ChucVu> service;
	List<ChucVu> list;
	
	public ServletChucVu() {
		service = new Service<>(ChucVu.class);
		list = new ArrayList<>();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("hien-thi")){
			this.hienThi(request, response);
		}
		else if (uri.contains("detail")){
			this.detailView(request, response);
		}else if (uri.contains("delete")){
			this.delete(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("add")){
			add(request, response);
		}else if (uri.contains("update")){
			update(request, response);
		}
	}
	
	private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list = service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/viewTest/ChucVuHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		ChucVu cv = new ChucVu();
		cv.setMa(ma);
		cv.setTen(ten);
		service.add(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/chuc-vu/hien-thi");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		ChucVu cv = service.findById(UUID.fromString(id));
		cv.setMa(ma);
		cv.setTen(ten);
		service.update(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/chuc-vu/hien-thi");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ChucVu cv = new ChucVu();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/chuc-vu/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChucVu cv = service.findById(UUID.fromString(request.getParameter("id")));
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/ChucVuChiTiet.jsp").forward(request, response);
	}
}
