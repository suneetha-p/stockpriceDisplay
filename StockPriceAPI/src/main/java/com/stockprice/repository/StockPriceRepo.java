package com.stockprice.repository;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stockprice.model.StockPrice;
import com.stockprice.model.StockPriceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface StockPriceRepo{
   List<StockPriceDTO> findAllStockPrices();
}
