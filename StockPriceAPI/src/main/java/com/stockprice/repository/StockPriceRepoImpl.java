package com.stockprice.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stockprice.model.StockPrice;
import com.stockprice.model.StockPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
@Repository
public class StockPriceRepoImpl implements StockPriceRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional(readOnly = true)
    @Override
    public List<StockPriceDTO> findAllStockPrices() {
       return entityManager.createNativeQuery("WITH T1 AS (SELECT * FROM (SELECT STOCK_SYMBOL  ,(BIDPRICE +ASKPRICE)/2 as price  ,DENSE_RANK() OVER (PARTITION BY STOCK_SYMBOL  ORDER BY EVENT_TIME  DESC) AS D_RANK FROM STOCKPRICE ) WHERE  D_RANK=1)  ,T2 AS (SELECT * FROM (SELECT STOCK_SYMBOL  ,(BIDPRICE +ASKPRICE)/2 as price ,DENSE_RANK() OVER (PARTITION BY STOCK_SYMBOL  ORDER BY EVENT_TIME  DESC) AS D_RANK FROM STOCKPRICE ) WHERE  D_RANK=2) SELECT T1. STOCK_SYMBOL as stockSymbol ,t1. price as price ,CASE WHEN t1.PRICE  > t2. PRICE   THEN 'UP' WHEN t1. PRICE  < t2. PRICE THEN  'DOWN' Else 'UP' end as trend   from  t1 Left join t2 on t1.STOCK_SYMBOL =t2.STOCK_SYMBOL","stockPriceMapping").getResultList();
    }
    @Transactional
    public void save(StockPrice stockPrice){
        entityManager.persist(stockPrice);
    }

    private List<ObjectNode> _toJson(List<Tuple> results) {
        List<ObjectNode> json = new ArrayList<ObjectNode>();
        ObjectMapper mapper = new ObjectMapper();
        for (Tuple t : results)
        {
            List<TupleElement<?>> cols = t.getElements();
            ObjectNode one = mapper.createObjectNode();
            for (TupleElement col : cols)
            {
                one.put(col.getAlias(), t.get(col.getAlias()).toString());
            }
            json.add(one);
        }
        return json;
    }

}
