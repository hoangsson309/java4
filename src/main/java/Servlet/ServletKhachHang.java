package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import model.ChucVu;
import model.CuaHang;
import model.KhachHang;
import service.iml.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "servletKhachHang", value = {
		"/khach-hang/hien-thi",
		"/khach-hang/add",
		"/khach-hang/update",
		"/khach-hang/delete",
		"/khach-hang/detail"
})
public class ServletKhachHang extends HttpServlet {
	Service<KhachHang> service;
	List<KhachHang> list;
	
	public ServletKhachHang() {
		service = new Service<>(KhachHang.class);
		list = new ArrayList<>();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("hien-thi")) {
			this.hienThi(request, response);
		} else if (uri.contains("detail")) {
			this.detailView(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}
	
	@SneakyThrows
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("add")) {
			this.add(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list = service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/viewTest/KhachHangHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String ho = request.getParameter("ho");
		String ngaySinh = request.getParameter("ngaySinh");
		String tenDem = request.getParameter("tenDem");
		String sdt = request.getParameter("sdt");
		String diaChi = request.getParameter("diaChi");
		KhachHang cv = new KhachHang();
		cv.setMa(ma);
		cv.setHo(ho);
		cv.setTenDem(tenDem);
		cv.setTen(ten);
		cv.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh));
		cv.setSdt(sdt);
		cv.setDiaChi(diaChi);
		service.add(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/khach-hang/hien-thi");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String id = request.getParameter("id");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String ho = request.getParameter("ho");
		String ngaySinh = request.getParameter("ngaySinh");
		String tenDem = request.getParameter("tenDem");
		String sdt = request.getParameter("sdt");
		String diaChi = request.getParameter("diaChi");
		KhachHang cv = service.findById(UUID.fromString(id));
		cv.setMa(ma);
		cv.setHo(ho);
		cv.setTenDem(tenDem);
		cv.setTen(ten);
		cv.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh));
		cv.setSdt(sdt);
		cv.setDiaChi(diaChi);
		service.update(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/khach-hang/hien-thi");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		KhachHang cv = new KhachHang();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/khach-hang/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhachHang cv = service.findById(UUID.fromString(request.getParameter("id")));
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/KhachHangChiTiet.jsp").forward(request, response);
	}
}
