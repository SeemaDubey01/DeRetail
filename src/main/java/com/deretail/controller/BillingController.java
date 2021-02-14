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
import com.deretail.repo.SellHeaderRepo;
import com.deretail.service.BillingService;

@Controller
@RequestMapping("/Billing")
public class BillingController {

	@Autowired
	SellHeaderRepo sellHeaderRepo;
	@Autowired
	BillingService billingService;
	
	@GetMapping("/NewBilling")
	public String newBilling(Model model, SearchInvoiceDTO modelDTO) {
		SellHeader header = new SellHeader();
		Integer lastBillNo;
		try {
			lastBillNo = sellHeaderRepo.findMaxBillNo();
		} catch (Exception e) {
			lastBillNo = 0;
		}
		
		
		if (modelDTO!=null && modelDTO.getBillNo() > 0 ) { /*search the bill and send on scree */
			Optional<SellHeader> headerMap = sellHeaderRepo.findById(modelDTO.getBillNo());
			if(headerMap.isPresent()) {
				header = headerMap.get();
			}
			SellDetails detail0 = new SellDetails();
			detail0.setBillNo(header.getBillNo());
			detail0.setItemNo(header.getTotalItem()+1);
			detail0.setProductCode(0);
			detail0.setProductDescr("Reversal of bill# " + modelDTO.getBillNo());
			detail0.setQuantity(1);
			detail0.setUnitPrice(header.getTotalBill() * -1);
			detail0.setTotalPrice(header.getTotalBill() * -1);
			header.getSellDetails().add(detail0);
		}
		
		header.setBillNo( lastBillNo + 1);
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
		model.addAttribute("header", header );
		return "PrintReceipt";
	}
	
	@GetMapping("/PrintReceipt")
	public String printReceipt(Model model, SearchInvoiceDTO modelDTO) {
		SellHeader header;
		if (modelDTO.getBillNo() > 0 ) {
			header = billingService.findByBillNo(modelDTO.getBillNo());
		}
		else {
			header = sellHeaderRepo.getOne(1);
		}
		model.addAttribute("header", header );
		return "PrintReceipt";
	}

	@GetMapping("/SearchInvoice")
	public String searchInvoice(Model model, SearchInvoiceDTO modelDTO) {
		List<SellHeader> sellList = new ArrayList<SellHeader>();
		//System.out.println("modelDTO: " + modelDTO.getBillNo() + " " + modelDTO.getStartDate() + " " + modelDTO.isBillNoCheck());
		
		if (modelDTO.isBillNoCheck() && modelDTO.getBillNo() > 0 ) {  //billNo given then search for exact billNo
			sellList.add(billingService.findByBillNo(modelDTO.getBillNo()));
			Date sDate = new Date(sellList.get(0).getDateSold().getTime());
			System.out.println("dateSold: " + sellList.get(0).getDateSold());
			modelDTO.setStartDate(sDate);
			modelDTO.setEndDate(sDate);
		}
		else {
			if (modelDTO.getStartDate() == null) { // first call of SearchInvoice
				sellList = billingService.getTodaysBills();
				Date today = new Date(System.currentTimeMillis());
				modelDTO.setStartDate(today);
				modelDTO.setEndDate(today);
			}
			else { // search based on date range
				sellList = billingService.getBillsWithinDates(modelDTO.getStartDate(), modelDTO.getEndDate());		
			}	
		}
		
		model.addAttribute("sellList", sellList);
		model.addAttribute("modelDTO", modelDTO);
		return "SearchInvoice";
	}
	
}
