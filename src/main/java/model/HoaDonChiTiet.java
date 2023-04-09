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
@IdClass(HoaDonChiTietId.class)
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
	@Id
	@ManyToOne
	@JoinColumn(name = "IdHoaDon")
	private HoaDon hoaDon;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "IdChiTietSP")
	private ChiTietSP chiTietSP;
	
	@Column(name = "SoLuong")
	private Integer soLuong;
	
	@Column(name = "DonGia")
	private BigDecimal donGia;
}
