package com.deretail.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deretail.dto.BrandMaster;
import com.deretail.repo.BrandMasterRepo;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
	@Autowired
	BrandMasterRepo brandMasterRepo;
	
	@GetMapping("/addBrand")
	public String getAddBrand(Model model) {
		BrandMaster brandMaster = new BrandMaster();
		model.addAttribute("brandMaster", brandMaster);
		return "addBrand";
	}
	
	@PostMapping("/addBrand")
	public String postAddPost(Model model, BrandMaster brandDetail) {
		System.out.println(brandDetail);
		brandMasterRepo.save(brandDetail);
		return "redirect:../UserHome";
	}
	
	@GetMapping("/searchItem")
	public String searchItem(BigDecimal barcode, Model model) {
		BrandMaster brandMaster = new BrandMaster();
		System.out.println("inside searchItem :" + brandMaster);
		if (barcode != null) {
			System.out.println("going to read brand master");
			Optional <BrandMaster> brandMasterMap = brandMasterRepo.findById(brandMaster.getBarcode());
			if (brandMasterMap.isPresent()) {
				brandMaster = brandMasterMap.get();
			}
		}
		model.addAttribute("brandMaster", brandMaster);
		return "searchItem";
	}
	
}
