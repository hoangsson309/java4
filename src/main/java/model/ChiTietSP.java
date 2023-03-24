package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ChiTietSP")
public class ChiTietSP {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "IdSP")
	private SanPham sanPham;
	
	@ManyToOne
	@JoinColumn(name = "IdNsx")
	private NSX nsx;
	
	@ManyToOne
	
	@Column(name = "IdMauSac")
	private MauSac mauSac;
	
	@ManyToOne
	
	@Column(name = "IdDongSP")
	private DongSP dongSP;
	
	@Column(name = "NamBH")
	private Integer namBH;
	
	@Column(name = "MoTa")
	private String moTa;
	
	@Column(name = "SoLuongTon")
	private Integer soLuongTon;
	
	@Column(name = "GiaNhap")
	private BigDecimal giaNhap;
	
	@Column(name = "GiaBan")
	private BigDecimal giaBan;
}
