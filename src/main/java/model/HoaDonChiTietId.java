package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HoaDonChiTietId implements Serializable {
	public HoaDon hoaDon;
	public ChiTietSP chiTietSP;
	
}
