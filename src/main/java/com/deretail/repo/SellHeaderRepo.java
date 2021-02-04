package com.deretail.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deretail.dto.SellHeader;

@Repository
public interface SellHeaderRepo extends JpaRepository<SellHeader, Integer>  {

	@Query(value = "SELECT MAX(billNo) FROM SellHeader")
	public int findMaxBillNo();
	
	@Query(value = "SELECT u FROM SellHeader u WHERE u.dateSold BETWEEN ?1 AND ?2")
	public List<SellHeader> findAllInDateRange(Timestamp t1, Timestamp t2);
}
