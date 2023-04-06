package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CuaHang;
import service.iml.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "servletCuaHang", value = {
		"/cua-hang/hien-thi",
		"/cua-hang/add",
		"/cua-hang/update",
		"/cua-hang/delete",
		"/cua-hang/detail"
})
public class ServletCuaHang extends HttpServlet {
	
	Service<CuaHang> service;
	List<CuaHang> list;
	
	public ServletCuaHang() {
		service = new Service<>(CuaHang.class);
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
		request.getRequestDispatcher("/viewTest/CuaHangHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String diaChi = request.getParameter("diaChi");
		String thanhPho = request.getParameter("thanhPho");
		String quocGia = request.getParameter("quocGia");
		CuaHang cv = new CuaHang();
		cv.setMa(ma);
		cv.setTen(ten);
		cv.setDiaChi(diaChi);
		cv.setThanhPho(thanhPho);
		cv.setQuocGia(quocGia);
		service.add(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/cua-hang/hien-thi");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String diaChi = request.getParameter("diaChi");
		String thanhPho = request.getParameter("thanhPho");
		String quocGia = request.getParameter("quocGia");
		CuaHang cv = service.findById(UUID.fromString(id));
		cv.setMa(ma);
		cv.setTen(ten);
		cv.setDiaChi(diaChi);
		cv.setThanhPho(thanhPho);
		cv.setQuocGia(quocGia);
		service.update(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/cua-hang/hien-thi");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CuaHang cv = new CuaHang();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/cua-hang/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CuaHang cv = service.findById(UUID.fromString(request.getParameter("id")));
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/CuaHangChiTiet.jsp").forward(request, response);
	}
}
