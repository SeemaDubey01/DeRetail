package com.deretail.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deretail.dto.DeRetailSellDetails;
import com.deretail.dto.DeRetailSellHeader;
import com.deretail.repo.SellDetailsRepo;
import com.deretail.repo.SellHeaderRepo;

@Controller
@RequestMapping("/Billing")
public class BillingController {

	@Autowired
	SellHeaderRepo sellHeaderRepo;
	@Autowired
	SellDetailsRepo sellDetailsRepo;
	
	@GetMapping("/BillingHome")
	public String billingHome() {
		return "BillingHome";
	}
	@GetMapping("/NewBilling")
	public String newBilling(Model model) {
		DeRetailSellHeader header = new DeRetailSellHeader();
		//header = sellHeaderRepo.findTopByOrderByIdDesc();
		System.out.println("last record : " + sellHeaderRepo.findMaxBillNo());
		model.addAttribute("header", header );
		return "NewBilling";
	}
	@PostMapping("/NewBilling")
	public String postNewBilling(Model model, DeRetailSellHeader header) {
		int i=0; int amt=0;
		for (DeRetailSellDetails s : header.getSellDetails()) {
			s.setDrsdTotalPrice(s.getDrsdQuantity() * s.getDrsdUnitPrice());;
			i++;
			s.setDrsdItemNo(i);
			s.setDrsdBillItem(header.getDrshBillNo()*10000 + i);
			amt += s.getDrsdTotalPrice();
			s.setDrshBillNo(header.getDrshBillNo());
			System.out.println(s);
		}
		header.setDrshTotalItem(i);
		header.setDrshTotalBill(amt);
		System.out.println("new header :" + header);
		sellHeaderRepo.save(header);
		return "redirect: /UserHome";
	}
	@GetMapping("/SearchInvoice")
	public String searchInvoice(Model model, Integer drshBillNo) {
		DeRetailSellHeader sell = new DeRetailSellHeader();
		if (drshBillNo!= null ) {
			Optional<DeRetailSellHeader> sellHeaderMap;
			sellHeaderMap = sellHeaderRepo.findById(drshBillNo);
			if(sellHeaderMap.isPresent()) {
				sell = sellHeaderMap.get();
			}
		}
		model.addAttribute("sell", sell);
		return "SearchInvoice";
	}
	
//	@GetMapping("/SearchInvoice/{sellMap}")
//	public String searchInvoiceWithBill(Model model, @PathVariable("sellMap") DeRetailSellDetails sellMap) {
//		System.out.println("inside search with bill no");
//		
//		System.out.println("header: " + sellHeader);
//		for (DeRetailSellDetails s : sellHeader.getSellDetails()) {
//			System.out.println("detail : " + s);
//		}
//		model.addAttribute("sell", sellHeader);
//		return "SearchInvoice";
//	}
	
//	@GetMapping("/SearchInvoice")
//	public String searchInvoiceWithBill2(Model model, int drshBillNo) {
//		System.out.println("search with int");
//		return "SearchInvoice";
//	}
	@GetMapping("/FeedInvoice")
	public String feedInvoice() {
		DeRetailSellHeader sellHeader = new DeRetailSellHeader();
		sellHeader.setDrshBillNo(2);
		sellHeader.setDrshSeller("Raju");
		sellHeader.setDrshTotalBill(100);
		sellHeader.setDrshTotalItem(2);
		System.out.println("header: " + sellHeader);
		int i;
		DeRetailSellDetails sellDetails;
		for (i=1;i<3;i++) {
			sellDetails = new DeRetailSellDetails();
			sellDetails.setDrsdBillItem(20000+i);
			sellDetails.setDrsdItemNo(i);
			sellDetails.setDrsdProductCode(111111+i);
			sellDetails.setDrsdQuantity(1);
			sellDetails.setDrsdTotalPrice(50*i);
			sellDetails.setDrsdUnitPrice(50*i);
			sellDetails.setDrshBillNo(2);
			
			sellHeader.getSellDetails().add(sellDetails);
			System.out.println("detail : " + sellDetails);
		}
		sellHeaderRepo.save(sellHeader);
		return "SearchInvoice";
	}
	
	@GetMapping("/ClearInvoice")
	public String clearInvoice() {
		sellHeaderRepo.deleteById(2);
		return "SearchInvoice";
	}
}
