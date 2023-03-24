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
@Table(name = "HoaDon")
public class HoaDon {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "IdKH")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "IdNV")
	private NhanVien nhanVien;
	
	@Column(name = "Ma")
	private String ma;
	
	@Column(name = "NgayTao")
	private Date ngayTao;
	
	@Column(name = "NgayThanhToan")
	private Date ngayThanhToan;
	
	@Column(name = "NgayShip")
	private Date ngayShip;
	
	@Column(name = "NgayNhan")
	private Date ngayNhan;
	
	@Column(name = "TinhTrang")
	private Integer tinhTrang;
	
	@Column(name = "TenNguoiNhan")
	private String tenNguoiNhan;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "Sdt")
	private String sdt;
	
	
}
