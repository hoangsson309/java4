package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import service.iml.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "servletChiTietSP", value = {
		"/chi-tiet-sp/hien-thi",
		"/chi-tiet-sp/add",
		"/chi-tiet-sp/update",
		"/chi-tiet-sp/delete",
		"/chi-tiet-sp/detail"
})
public class ServletChiTietSP extends HttpServlet {
	
	Service<ChiTietSP> service;
	List<ChiTietSP> list;
	
	Service<SanPham> serviceSP;
	Service<NSX> serviceNSX;
	Service<MauSac> serviceMS;
	Service<DongSP> serviceDongSP;
	
	List<SanPham> listSP;
	List<NSX> listNSX;
	List<MauSac> listMS;
	List<DongSP> listDongSP;
	
	public ServletChiTietSP() {
		service = new Service<>(ChiTietSP.class);
		list = new ArrayList<>();
		serviceSP = new Service<>(SanPham.class);
		serviceNSX = new Service<>(NSX.class);
		serviceMS = new Service<>(MauSac.class);
		serviceDongSP = new Service<>(DongSP.class);
		listSP = serviceSP.getAll();
		listNSX = serviceNSX.getAll();
		listMS = serviceMS.getAll();
		listDongSP = serviceDongSP.getAll();
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
			this.add(request, response);
		}else if (uri.contains("update")){
			this.update(request, response);
		}
	}
	
	private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list = service.getAll();
		request.setAttribute("list", list);
		listSP = serviceSP.getAll();
		listNSX = serviceNSX.getAll();
		listMS = serviceMS.getAll();
		listDongSP = serviceDongSP.getAll();
		request.setAttribute("listSP", listSP);
		request.setAttribute("listNSX", listNSX);
		request.setAttribute("listMS", listMS);
		request.setAttribute("listDongSP", listDongSP);
		request.getRequestDispatcher("/viewTest/ChiTietSPHienThi.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSP = request.getParameter("sanPham");
		String idNSX = request.getParameter("nsx");
		String idMS = request.getParameter("mauSac");
		String idDongSP = request.getParameter("dongSP");
		String namBH = request.getParameter("namBH");
		String soLuongTon = request.getParameter("soLuongTon");
		String giaNhap = request.getParameter("giaNhap");
		String giaBan = request.getParameter("giaBan");
		ChiTietSP ctsp = new ChiTietSP();
		ctsp.setSanPham(serviceSP.findById(UUID.fromString(idSP)));
		ctsp.setNsx(serviceNSX.findById(UUID.fromString(idNSX)));
		ctsp.setMauSac(serviceMS.findById(UUID.fromString(idMS)));
		ctsp.setDongSP(serviceDongSP.findById(UUID.fromString(idDongSP)));
		ctsp.setNamBH(Integer.valueOf(namBH));
		ctsp.setSoLuongTon(Integer.valueOf(soLuongTon));
		ctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(giaNhap)));
		ctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(giaBan)));
		service.add(ctsp);
		request.setAttribute("list", list);
		response.sendRedirect("/chi-tiet-sp/hien-thi");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String idSP = request.getParameter("sanPham");
		String idNSX = request.getParameter("nsx");
		String idMS = request.getParameter("mauSac");
		String idDongSP = request.getParameter("dongSP");
		String namBH = request.getParameter("namBH");
		String soLuongTon = request.getParameter("soLuongTon");
		String giaNhap = request.getParameter("giaNhap");
		String giaBan = request.getParameter("giaBan");
		ChiTietSP ctsp = service.findById(UUID.fromString(id));
		ctsp.setSanPham(serviceSP.findById(UUID.fromString(idSP)));
		ctsp.setNsx(serviceNSX.findById(UUID.fromString(idNSX)));
		ctsp.setMauSac(serviceMS.findById(UUID.fromString(idMS)));
		ctsp.setDongSP(serviceDongSP.findById(UUID.fromString(idDongSP)));
		ctsp.setNamBH(Integer.valueOf(namBH));
		ctsp.setSoLuongTon(Integer.valueOf(soLuongTon));
		ctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(giaNhap)));
		ctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(giaBan)));
		service.update(ctsp);
		request.setAttribute("list", list);
		response.sendRedirect("/chi-tiet-sp/hien-thi");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ChiTietSP cv = new ChiTietSP();
		cv.setId(UUID.fromString(id));
		service.delete(cv);
		request.setAttribute("list", list);
		response.sendRedirect("/chi-tiet-sp/hien-thi");
	}
	
	private void detailView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChiTietSP ctsp = service.findById(UUID.fromString(request.getParameter("id")));
		listSP = serviceSP.getAll();
		listNSX = serviceNSX.getAll();
		listMS = serviceMS.getAll();
		listDongSP = serviceDongSP.getAll();
		request.setAttribute("listSP", listSP);
		request.setAttribute("listNSX", listNSX);
		request.setAttribute("listMS", listMS);
		request.setAttribute("listDongSP", listDongSP);
		request.setAttribute("cv", ctsp);
		request.getRequestDispatcher("/viewTest/ChiTietSPChiTiet.jsp").forward(request, response);
	}
}
