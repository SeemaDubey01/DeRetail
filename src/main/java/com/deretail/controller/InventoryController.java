package com.deretail.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deretail.dto.DeRetailInventory;
import com.deretail.repo.InventoryRepo;

@Controller
@RequestMapping("/InventoryHome")
public class InventoryController {
	@Autowired
	InventoryRepo inventoryRepo;
	
	@GetMapping("/")
	public String entryHome() {
		return "EntryHome";
	}

	@GetMapping("/NewItem")
	public String newItem() {
		DeRetailInventory inventory = new DeRetailInventory();
		inventory.setDriBrand("Nestle");
		inventory.setDriProdDescr("Chocolates");
		inventory.setDriProductCode(1001);
		inventory.setDriSellingPrice(20.00);
		inventory.setDriStock(4);
		inventory.setDriUnitPrice(12.00);
		inventoryRepo.save(inventory);
		return "Item";
	}
	
	@GetMapping("/SearchItem")
	public String searchItem() {
		List<DeRetailInventory> inventory = new ArrayList<DeRetailInventory>();
		inventory = inventoryRepo.findAll();
		for (DeRetailInventory i : inventory) {
			System.out.println(i);
		}
		return "Item";
	}
	
	@GetMapping("/SearchItem/{productNo}")
	public String searchItem(@PathVariable ("productNo") int productNo) {
		Optional<DeRetailInventory> inventory;
		
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
		inventoryRepo.deleteById(1001);
		return "Item";
	}
}
