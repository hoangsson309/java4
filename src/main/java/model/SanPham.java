package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import repository.iml.Repository;
import service.iml.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue
	private UUID id;
	@Column(name = "Ma")
	private String ma;
	@Column(name = "Ten")
	private String ten;
	
	public static void main(String[] args) {
		Service<ChucVu> service = new Service<>(ChucVu.class);
		System.out.println(service.getAll().size());
		List<ChucVu> list = service.getAll();
//		ChucVu cv = new ChucVu();
//		cv.setId(UUID.fromString("C2A85E39-B588-B24A-A5A3-19A3F9EAB26B"));
//		cv.setMa("TP01kgffg");
//		cv.setTen("Trưởng phòng nguuuu");
		
		ChucVu cv = new ChucVu(list.get(0).getId(), "Tp","Trưởng phòng");
		System.out.println(service.update(cv) ? "Update success" : "Update Error");
		
//		for (ChucVu x :list) {
//			System.out.println(x.getId());
//			System.out.println(x.getTen());
//			System.out.println(x.getMa());
//		}
	}
}
