/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.util.Properties;
import model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author HOANG SON
 */
public class HibernateUtil {
	private static SessionFactory FACTORY;
	
	static {
		try {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=java4;useSSL=true"
					+ ";encrypt=true;trustServerCertificate=true;");
			settings.put(Environment.USER, "hns");
			settings.put(Environment.PASS, "1");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
			settings.put(Environment.SHOW_SQL, "true");
			
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Student.class);
			
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
		System.out.println(getSessionFactory().isOpen());
	}
}