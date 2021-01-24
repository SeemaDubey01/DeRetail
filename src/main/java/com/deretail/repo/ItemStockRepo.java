package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deretail.dto.ItemStock;

public interface ItemStockRepo extends JpaRepository<ItemStock, Integer>{

}
