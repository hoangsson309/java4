package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "KhachHang")
public class KhachHang {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "Ma")
	private String ma;
	
	@Column(name = "Ten")
	private String ten;
	
	@Column(name = "TenDem")
	private String tenDem;
	
	@Column(name = "Ho")
	private String ho;
	
	@Column(name = "NgaySinh")
	private Date ngaySinh;
	
	@Column(name = "Sdt")
	private String sdt;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "ThanhPho")
	private String thanhPho;
	
	
	@Column(name = "QuocGia")
	private String quocGia;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	
	
}
