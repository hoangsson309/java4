/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.util.Properties;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory FACTORY;
	
	static {
		try {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;useSSL=true"
					+ ";encrypt=true;trustServerCertificate=true;");
			settings.put(Environment.USER, "hns");
			settings.put(Environment.PASS, "1");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
			settings.put(Environment.SHOW_SQL, "true");
			
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(ChiTietSP.class);
			configuration.addAnnotatedClass(ChucVu.class);
			configuration.addAnnotatedClass(CuaHang.class);
			configuration.addAnnotatedClass(DongSP.class);
			configuration.addAnnotatedClass(GioHang.class);
			configuration.addAnnotatedClass(GioHangChiTiet.class);
			configuration.addAnnotatedClass(HoaDon.class);
			configuration.addAnnotatedClass(HoaDonChiTiet.class);
			configuration.addAnnotatedClass(KhachHang.class);
			configuration.addAnnotatedClass(MauSac.class);
			configuration.addAnnotatedClass(NSX.class);
			configuration.addAnnotatedClass(NhanVien.class);
			configuration.addAnnotatedClass(SanPham.class);
			
			ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			FACTORY = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	public static void main(String[] args) {
		System.out.println(getSessionFactory().isOpen() ? "Connect success" : "Connect error");
	}
}