package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChiTietSP;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import service.iml.Service;
import view_model.SanPhamResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@WebServlet(name = "ServletGioHang", value = {
		"/gio-hang/hien-thi",
		"/gio-hang/add",
		"/gio-hang/delete",
		"/gio-hang/thanh-toan",
})
public class ServletGioHang extends HttpServlet {
	private Service<ChiTietSP> serviceCTSP;
	private Service<HoaDon> serviceHD;
	private Service<KhachHang> serviceKH;
	private Service<HoaDonChiTiet> serviceHDCT;
	private List<ChiTietSP> list;
	private List<SanPhamResponse> listRespone;
	
	public ServletGioHang() {
		serviceCTSP = new Service<>(ChiTietSP.class);
		serviceHD = new Service<>(HoaDon.class);
		serviceHDCT = new Service<>(HoaDonChiTiet.class);
		serviceKH = new Service<>(KhachHang.class);
		list = new ArrayList<>();
		listRespone = new ArrayList<>();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("hien-thi")) {
			this.viewHT(request, response);
		} else if (uri.contains("add")) {
			this.addSPToCart(request, response);
		}else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("thanh-toan")) {
			thanhToan(request, response);
		}
	}
	
	protected void thanhToan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<SanPhamResponse> giohang = (List<SanPhamResponse>) session.getAttribute("giohang");
		KhachHang kh = new KhachHang();
		String hoTen = request.getParameter("kh_ten");
		String[] hoTenArr = hoTen.split(" ");
		String sdt = request.getParameter("kh_sdt");
		String diachi = request.getParameter("kh_diaChi");
		String diachiNhanHang = request.getParameter("hd_diaChi");
		kh.setMa(zenMaKH());
		kh.setSdt(sdt);
		kh.setHo(hoTenArr[0]);
		String tendem = "";
		for (int i = 1; i < hoTenArr.length-1; i++) {
			tendem += hoTenArr[i] +" ";
		}
		kh.setTenDem(tendem);
		kh.setTen(hoTenArr[hoTenArr.length-1]);
		kh.setDiaChi(diachi);
		HoaDon hd = new HoaDon();
		hd.setMa(zenHoadon());
		hd.setKhachHang(kh);
		hd.setTenNguoiNhan(hoTen);
		hd.setSdt(sdt);
		hd.setNgayTao(new Date());
		hd.setDiaChi(diachiNhanHang);
		serviceKH.add(kh);
		serviceHD.add(hd);
		System.err.println("size" + giohang.size());
		for (int i = 0; i < giohang.size(); i++) {
			HoaDonChiTiet hdct = new HoaDonChiTiet();
			hdct.setHoaDon(hd);
			ChiTietSP chiTietSP = serviceCTSP.findById(giohang.get(i).getId());
			System.err.println(chiTietSP.toString());
			hdct.setChiTietSP(chiTietSP);
			hdct.setSoLuong(giohang.get(i).getSoLuong());
			hdct.setDonGia(giohang.get(i).getGiaBan());
			System.err.println(hdct.toString());
			serviceHDCT.add(hdct);
		}
		response.sendRedirect("/dssp/hien-thi");
		giohang = null;
		session.removeAttribute("giohang");
		return;
	}
	
	protected void viewHT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/GioHang.jsp").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<SanPhamResponse> giohang = (List<SanPhamResponse>) session.getAttribute("giohang");
		String idCTSP = request.getParameter("id");
		int contains = checkContains(UUID.fromString(idCTSP), giohang);
		giohang.remove(contains);
		System.err.println(giohang.size());
		session.setAttribute("giohang", giohang);
		request.getRequestDispatcher("/view/GioHang.jsp").forward(request, response);
	}
	
	protected void addSPToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("giohang") == null) {
			List<SanPhamResponse> giohang = new ArrayList<>();
			String idCTSP = request.getParameter("id");
			SanPhamResponse sp = initModel(UUID.fromString(idCTSP));
			giohang.add(sp);
			session.setAttribute("giohang", giohang);
		} else {
			String idCTSP = request.getParameter("id");
			List<SanPhamResponse> giohang = (List<SanPhamResponse>) session.getAttribute("giohang");
			int contains = checkContains(UUID.fromString(idCTSP), giohang);
			if (contains == -1) {
				SanPhamResponse sp = initModel(UUID.fromString(idCTSP));
				giohang.add(sp);
			} else {
				giohang.get(contains).setSoLuong(giohang.get(contains).getSoLuong() + 1);
			}
			session.setAttribute("giohang", giohang);
		}
		response.sendRedirect("/gio-hang/hien-thi");
	}
	
	private Integer checkContains(UUID id, List<SanPhamResponse> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	private SanPhamResponse initModel(UUID id) {
		ChiTietSP chiTietSP = serviceCTSP.findById(id);
		SanPhamResponse sanPhamResponse = new SanPhamResponse();
		sanPhamResponse.setId(chiTietSP.getId());
		sanPhamResponse.setSanPham(chiTietSP.getSanPham());
		sanPhamResponse.setMauSac(chiTietSP.getMauSac());
		sanPhamResponse.setDongSP(chiTietSP.getDongSP());
		sanPhamResponse.setGiaBan(chiTietSP.getGiaBan());
		sanPhamResponse.setGiaNhap(chiTietSP.getGiaNhap());
		sanPhamResponse.setSoLuong(1);
		return sanPhamResponse;
	}
	
	private String zenHoadon() {
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String timeNow = day + "" + month + "" + year + "" + hour + "" + min + "" + second;
		return "HD"+timeNow;
	}
	
	private String zenMaKH() {
		Random random = new Random();
		int ran = random.nextInt() + 9999999 + 1;
		return "KH" + ran;
	}
}
