package com.stockprice;

import com.stockprice.model.StockPriceDTO;
import com.stockprice.repository.StockPriceRepoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
//Integration test class
@RunWith(SpringRunner.class)
    @DataJpaTest
    public class StockPriceRepoImplTest {
    @Autowired
    private StockPriceRepoImpl stockPriceRepoImpl;
    List<StockPriceDTO> dummyStockPriceDTOList=new ArrayList<>();
    @Before
    public void  init(){

        StockPriceDTO stockPriceDTO=new StockPriceDTO("D05:sgx",56,"down");
        StockPriceDTO stockPriceDTO1=new StockPriceDTO("G05:sgx",111,"up");
        StockPriceDTO stockPriceDTO2=new StockPriceDTO("F05:sgx",13.25,"down");
        StockPriceDTO stockPriceDTO3=new StockPriceDTO("EE05:sgx",13.25,"down");
        dummyStockPriceDTOList.add(stockPriceDTO1) ;
        dummyStockPriceDTOList.add(stockPriceDTO2) ;
        dummyStockPriceDTOList.add(stockPriceDTO3) ;
        dummyStockPriceDTOList.add(stockPriceDTO) ;
    }

    @Test
    @Transactional
    @Rollback(true)
        public void findAllStockPricesTest() {
             List<StockPriceDTO> stockPriceDTOList = stockPriceRepoImpl.findAllStockPrices();
             Assert.assertEquals(dummyStockPriceDTOList.size(),stockPriceDTOList.size());

        }
    }

