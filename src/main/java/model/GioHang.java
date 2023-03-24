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
@Table(name = "GioHang")
public class GioHang {
	
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
	
	@Column(name = "TenNguoiNhan")
	private String tenNguoiNhan;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "Sdt")
	private String sdt;
	
	@Column(name = "TinhTrang")
	private String tinhTrang;
	
}
