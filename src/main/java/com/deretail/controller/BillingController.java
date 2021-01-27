package com.deretail.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.deretail.dto.SearchInvoiceDTO;
import com.deretail.dto.SellDetails;
import com.deretail.dto.SellHeader;
import com.deretail.repo.SellDetailsRepo;
import com.deretail.repo.SellHeaderRepo;

@Controller
@RequestMapping("/Billing")
public class BillingController {

	@Autowired
	SellHeaderRepo sellHeaderRepo;
	@Autowired
	SellDetailsRepo sellDetailsRepo;
	
	@GetMapping("/NewBilling")
	public String newBilling(Model model) {
		SellHeader header = new SellHeader();
		Integer lastBillNo;
		try {
			lastBillNo = sellHeaderRepo.findMaxBillNo();
		} catch (Exception e) {
			lastBillNo = 0;
		}
	
		header.setBillNo( lastBillNo + 1);
		header.setSeller("Loggedin");
		//System.out.println("last record : " + header.getBillNo());
		model.addAttribute("header", header );
		return "NewBilling";
	}
	
	@PostMapping("/NewBilling")
	public String postNewBilling(Model model, SellHeader header) {
		int i=0; double amt=0;
		for (SellDetails s : header.getSellDetails()) {
			s.setTotalPrice(s.getQuantity() * s.getUnitPrice());;
			i++;
			s.setItemNo(i);
			s.setBillItem(header.getBillNo()*10000 + i);
			amt += s.getTotalPrice();
			s.setBillNo(header.getBillNo());
			System.out.println("sellDetails: "+ s);
		}
		header.setTotalItem(i);
		header.setTotalBill(amt);
		System.out.println("new header :" + header);
		sellHeaderRepo.save(header);
		return "redirect:../UserHome";
	}
	
	@GetMapping("/SearchInvoice")
	public String searchInvoice(Model model, SearchInvoiceDTO modelDTO) {
		List<SellHeader> sellList = new ArrayList<SellHeader>();
		System.out.println("modelDTO: " + modelDTO.getBillNo() + " " + modelDTO.getStartDate());
		if (modelDTO.getBillNo() > 0 ) {
			Optional<SellHeader> sellHeaderMap;
			sellHeaderMap = sellHeaderRepo.findById(modelDTO.getBillNo());
			if(sellHeaderMap.isPresent()) {
				sellList.add(sellHeaderMap.get());
			}
		}
		else {
			sellList = sellHeaderRepo.findAll();
		}
		model.addAttribute("sellList", sellList);
		model.addAttribute("modelDTO", modelDTO);
		return "SearchInvoice";
	}
	
	@GetMapping("/FeedInvoice")
	public String feedInvoice() {
		SellHeader sellHeader = new SellHeader();
		sellHeader.setBillNo(2);
		sellHeader.setSeller("Raju");
		sellHeader.setTotalBill(100);
		sellHeader.setTotalItem(2);
		System.out.println("header: " + sellHeader);
		int i;
		SellDetails sellDetails;
		for (i=1;i<3;i++) {
			sellDetails = new SellDetails();
			sellDetails.setBillItem(20000+i);
			sellDetails.setItemNo(i);
			sellDetails.setProductCode(111111+i);
			sellDetails.setQuantity(1);
			sellDetails.setTotalPrice(50*i);
			sellDetails.setUnitPrice(50*i);
			sellDetails.setBillNo(2);
			
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
