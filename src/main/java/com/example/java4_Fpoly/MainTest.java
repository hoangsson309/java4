package com.example.java4_Fpoly;

import model.ChucVu;
import service.iml.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class MainTest {
	public static void main(String[] args) {
		Service<ChucVu> service = new Service<>(ChucVu.class);
		System.out.println(service.getAll().size());
		List<ChucVu> list = service.getAll();
//		cv.setId(UUID.fromString("C2A85E39-B588-B24A-A5A3-19A3F9EAB26B"));
//		cv.setMa("TP01kgffg");
//		cv.setTen("Trưởng phòng nguuuu");

//		ChucVu cv = new ChucVu(list.get(0).getId(), "Tp","Trưởng phòng");
//		System.out.println(service.update(cv) ? "Update success" : "Update Error");
//		System.out.println(list.get(0).getId());
//		System.out.println(list.get(0).getId().toString());
		
		for (ChucVu x :list) {
			System.out.println(x.getId());
			System.out.println(x.getTen());
			System.out.println(x.getMa());
		}
		
		ChucVu cv = service.findById(UUID.fromString("c3c994ae-32eb-3a46-8af5-992c91552775"));
		System.out.println(cv.toString());
	}
}
