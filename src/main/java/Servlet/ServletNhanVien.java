package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChucVu;
import model.CuaHang;
import model.NhanVien;
import service.iml.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "servletNhanVien", value = {
		"/nhan-vien/hien-thi",
		"/nhan-vien/add",
		"/nhan-vien/update",
		"/nhan-vien/delete",
		"/nhan-vien/detail"
})
public class ServletNhanVien extends HttpServlet {
	
	Service<NhanVien> service;
	List<NhanVien> list;
	
	Service<ChucVu> serviceCV;
	List<ChucVu> listCV;
	
	Service<CuaHang> serviceCH;
	List<CuaHang> listCH;
	
	public ServletNhanVien() {
		service = new Service<>(NhanVien.class);
		serviceCV = new Service<>(ChucVu.class);
		serviceCH = new Service<>(CuaHang.class);
		list = new ArrayList<>();
		listCV = serviceCV.getAll();
		listCH = serviceCH.getAll();
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
		listCV = serviceCV.getAll();
		listCH = serviceCH.getAll();
		request.setAttribute("listCV", listCV);
		request.setAttribute("listCH", listCH);
		request.getRequestDispatcher("/viewTest/NhanVienHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String ho = request.getParameter("ho");
		String tenDem = request.getParameter("tenDem");
		String gioiTinh = request.getParameter("gioiTinh");
		String sdt = request.getParameter("sdt");
		String idCh = request.getParameter("cuaHang");
		String idCv = request.getParameter("chucVu");
		String trangThai = request.getParameter("trangThai");
		NhanVien cv = new NhanVien();
		cv.setMa(ma);
		cv.setHo(ho);
		cv.setTenDem(tenDem);
		cv.setTen(ten);
		cv.setGioiTinh(gioiTinh);
		cv.setSdt(sdt);
		cv.setTrangThai(Integer.valueOf(trangThai));
		cv.setCuaHang(serviceCH.findById(UUID.fromString(idCh)));
		cv.setChucVu(serviceCV.findById(UUID.fromString(idCv)));
		service.add(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/nhan-vien/hien-thi");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ma = request.getParameter("ma");
		String ten = request.getParameter("ten");
		String ho = request.getParameter("ho");
		String tenDem = request.getParameter("tenDem");
		String gioiTinh = request.getParameter("gioiTinh");
		String sdt = request.getParameter("sdt");
		String idCh = request.getParameter("cuaHang");
		String idCv = request.getParameter("chucVu");
		String trangThai = request.getParameter("trangThai");
		NhanVien cv = service.findById(UUID.fromString(id));
		cv.setMa(ma);
		cv.setHo(ho);
		cv.setTenDem(tenDem);
		cv.setTen(ten);
		cv.setGioiTinh(gioiTinh);
		cv.setSdt(sdt);
		cv.setTrangThai(Integer.valueOf(trangThai));
		cv.setCuaHang(serviceCH.findById(UUID.fromString(idCh)));
		cv.setChucVu(serviceCV.findById(UUID.fromString(idCv)));
		service.add(cv);
		service.update(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/nhan-vien/hien-thi");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		NhanVien cv = new NhanVien();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/nhan-vien/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhanVien cv = service.findById(UUID.fromString(request.getParameter("id")));
		listCV = serviceCV.getAll();
		listCH = serviceCH.getAll();
		request.setAttribute("listCV", listCV);
		request.setAttribute("listCH", listCH);
		request.setAttribute("cv", cv);
		request.getRequestDispatcher("/viewTest/NhanVienChiTiet.jsp").forward(request, response);
	}
}
