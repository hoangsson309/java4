package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChiTietSP;
import repository.iml.Repository;
import service.iml.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletDanhSacSanPham", value = "/dssp/hien-thi")
public class ServletDanhSacSanPham extends HttpServlet {
	
	Service<ChiTietSP> service;
	List<ChiTietSP> list;
	
	public ServletDanhSacSanPham() {
		service = new Service<>(ChiTietSP.class);
		list = new ArrayList<>();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("hien-thi")){
			this.viewHT(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void viewHT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list = service.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/SanPham.jsp").forward(request, response);
	}
}
