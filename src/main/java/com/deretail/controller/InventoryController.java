package com.deretail.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deretail.dto.InventoryMaster;
import com.deretail.repo.InventoryRepo;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
	@Autowired
	InventoryRepo inventoryRepo;
	
	@GetMapping("/")
	public String entryHome() {
		return "EntryHome";
	}
	
	@GetMapping("/InventoryMaster")
	public String inventoryMaster() {
		return "inventoryMaster";
	}

	@GetMapping("/addInventory")
	public String newItem() {
		return "addInventory";
	}
	@GetMapping("/addInventorySample")
	public String newItemSample() {
		InventoryMaster inventory = new InventoryMaster();
		inventory.setBrand("Nestle");
		inventory.setProdDescr("Chocolates");
		inventory.setProductCode(1001);
		inventory.setSellingPrice(20.00);
		inventory.setStock(4);
		inventory.setUnitPrice(12.00);
		inventoryRepo.save(inventory);
		return "addInventory";
	}
	
	@GetMapping("/SearchItem")
	public String searchItem() {
		List<InventoryMaster> inventory = new ArrayList<InventoryMaster>();
		inventory = inventoryRepo.findAll();
		for (InventoryMaster i : inventory) {
			System.out.println(i);
		}
		return "Item";
	}
	
	@GetMapping("/SearchItem/{productNo}")
	public String searchItem(@PathVariable ("productNo") int productNo) {
		Optional<InventoryMaster> inventory;
		
		inventory = inventoryRepo.findById(productNo);
		if (inventory.isPresent()) {	
				System.out.println(inventory);
		}
		else {
			System.out.println("Product not found");
		}
		return "Item";
	}
	@GetMapping("/ClearItem")
	public String clearItem() {
		//inventoryRepo.deleteById(1001);
		return "Item";
	}
}
