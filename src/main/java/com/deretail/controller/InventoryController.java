package com.deretail.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deretail.dto.BrandMaster;
import com.deretail.dto.ProductList;
import com.deretail.dto.SearchProductDTO;
import com.deretail.repo.BrandMasterRepo;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
	@Autowired
	BrandMasterRepo brandMasterRepo;
	
	@GetMapping("/AddProduct")
	public String getAddProduct(Model model) {
		List<BrandMaster> productList = new ArrayList<BrandMaster>();
		model.addAttribute("productList", productList);
		return "AddProduct";
	}
	
	@PostMapping("/AddProduct")
	public String postAddProduct(Model model, ProductList productList) {
		for (BrandMaster b: productList.getProductArray()) {
			brandMasterRepo.save(b);
		}
		return "UserHome";
	}

	@GetMapping("/SearchProduct")
	public String getSearchProduct(Model model, SearchProductDTO searchDTO) {
		ProductList productList = new ProductList();
		productList.setProductArray(new ArrayList<BrandMaster>());
		
		if (searchDTO.getDtoSearchOption() != null ) {
			System.out.println(searchDTO);
			switch(searchDTO.getDtoSearchOption()) {
			case "Code":
				if (searchDTO.getDtoProductCode() != null) {
					Optional<BrandMaster> brandMasterMap = brandMasterRepo.findById(searchDTO.getDtoProductCode());
					if (brandMasterMap.isPresent()) {
						productList.getProductArray().add(brandMasterMap.get());
					}
				}
			
			case "Brand":
				if (searchDTO.getDtoBrand() != null) {
					productList.setProductArray(brandMasterRepo.findByBrandContains(searchDTO.getDtoBrand()));
				}
			case "Name":
				if (searchDTO.getDtoProductName() != null) {
					productList.setProductArray(brandMasterRepo.findByProdNameContains(searchDTO.getDtoProductName()));
				}
			}
		}
		else {searchDTO.setDtoSearchOption("Code");}
		
		//productList.setProductArray(brandMasterRepo.findAll());
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("productList", productList);
		return "SearchProduct";
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
