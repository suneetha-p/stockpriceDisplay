package com.stockprice;

import com.stockprice.model.StockPriceDTO;
import com.stockprice.repository.StockPriceRepoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PriceControllerTest  extends AbstractTest{
    @MockBean
    private StockPriceRepoImpl stockPriceRepo;
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
    public void getStockPrice() throws Exception {
        String uri = "/price";
        when(stockPriceRepo.findAllStockPrices()).thenReturn(dummyStockPriceDTOList);
        ResultActions ra=mvc.perform(MockMvcRequestBuilders.get(uri) .accept(MediaType.APPLICATION_JSON_VALUE));
        MvcResult mvcResult = ra.andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        StockPriceDTO [] stockPriceDTOList = super.mapFromJson(content, StockPriceDTO[].class);
        Assert.assertTrue(stockPriceDTOList.length > 0);
    }
}
