package view_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SanPhamResponse {
	private UUID id;
	
	private SanPham sanPham;
	
	private NSX nsx;
	
	private MauSac mauSac;
	
	private DongSP dongSP;
	
	private Integer namBH;
	
	private String moTa;
	
	private Integer soLuongTon;
	
	private BigDecimal giaNhap;
	
	private BigDecimal giaBan;
	
	private Integer soLuong;
}
