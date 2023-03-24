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
@Table(name = "NhanVien")
public class NhanVien {
	
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
	
	@Column(name = "GioiTinh")
	private String gioiTinh;
	
	@Column(name = "NgaySinh")
	private Date ngaySinh;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "Sdt")
	private String sdt;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@ManyToOne
	@JoinColumn(name = "IdCH")
	private CuaHang cuaHang;
	
	@ManyToOne
	@JoinColumn(name = "IdCV")
	private ChucVu chucVu;
	
	@Column(name = "IdGuiBC")
	private UUID idGuiBC;
	
	@Column(name = "TrangThai")
	private Integer trangThai;
	
}
