package com.stockprice.controller;

import com.stockprice.model.StockPrice;
import com.stockprice.model.StockPriceDTO;
import com.stockprice.repository.StockPriceRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class PriceController {
    @Autowired
    private StockPriceRepoImpl stockPriceRepo;
    @GetMapping(value="price")
    public  ResponseEntity getStockPrice(){
        List<StockPriceDTO> stockPriceDTOList= stockPriceRepo.findAllStockPrices();
        HttpStatus status = stockPriceDTOList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<StockPriceDTO> >(stockPriceDTOList, status);
    }
    @PostMapping(value="createStockPrice")
    public  void createStockPrice(@RequestBody StockPrice stockPrice){
       stockPriceRepo.save(stockPrice);

    }
}
