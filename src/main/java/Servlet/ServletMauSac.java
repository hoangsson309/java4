package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MauSac;
import service.iml.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "servletMauSac", value = {
		"/mau-sac/hien-thi",
		"/mau-sac/add",
		"/mau-sac/update",
		"/mau-sac/delete",
		"/mau-sac/detail"
})
public class ServletMauSac extends HttpServlet {
	
	Service<MauSac> service;
	List<MauSac> list;
	
	public ServletMauSac() {
		service = new Service<>(MauSac.class);
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
		request.getRequestDispatcher("/viewTest/MauSacHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		MauSac cv = new MauSac();
		cv.setMa(ma);
		cv.setTen(ten);
		service.add(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/mau-sac/hien-thi");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		MauSac cv = service.findById(UUID.fromString(id));
		cv.setMa(ma);
		cv.setTen(ten);
		service.update(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/mau-sac/hien-thi");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MauSac cv = new MauSac();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/mau-sac/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MauSac cv = service.findById(UUID.fromString(request.getParameter("id")));
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/MauSacChiTiet.jsp").forward(request, response);
	}
}
