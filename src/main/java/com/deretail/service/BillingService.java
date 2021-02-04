package com.deretail.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deretail.dto.SellHeader;
import com.deretail.repo.SellHeaderRepo;

@Service
public class BillingService {

	@Autowired SellHeaderRepo sellHeaderRepo;
	
	public SellHeader findByBillNo(Integer billNo) {
		SellHeader sellHeader = new SellHeader();
		Optional<SellHeader> sellHeaderMap;
		sellHeaderMap = sellHeaderRepo.findById(billNo);
		if(sellHeaderMap.isPresent()) {
			sellHeader = sellHeaderMap.get();
		}
		return sellHeader;
	}
	/* search all invoices generated today */
	public List<SellHeader> getTodaysBills() {
		List<SellHeader> sellList = new ArrayList<SellHeader>();
		LocalDate today = LocalDate.now();
		Timestamp t1 = Timestamp.valueOf(today.atTime(0, 0,0));
		Timestamp t2 = Timestamp.valueOf(today.atTime(23,59,59));
		sellList = sellHeaderRepo.findAllInDateRange(t1, t2);
		return sellList;
	}
	
	/* search based on date range */
	public List<SellHeader> getBillsWithinDates(Date startDate, Date endDate) { //modelDTO.getStartDate(), modelDTO.getStartDate()
		List<SellHeader> sellList = new ArrayList<SellHeader>();
		Timestamp t1 = new Timestamp(startDate.getTime());
		Timestamp t2 = new Timestamp(endDate.getTime() + 24*60*60*1000 - 1);
		System.out.println("date range: " + t1 + " to " + t2);
		sellList = sellHeaderRepo.findAllInDateRange(t1, t2);
		return sellList;
	}
}
