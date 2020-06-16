package com.stockprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@SqlResultSetMapping(name="stockPriceMapping",
        classes = @ConstructorResult(
                targetClass = StockPriceDTO.class,
                columns = {
                        @ColumnResult(name="stockSymbol",type = String.class),
                        @ColumnResult(name="price",type = Double.class),
                        @ColumnResult(name="trend",type = String.class)
                }
        ))
@Entity
public class StockPriceDTO {
  @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
          @JsonIgnore
    Long id;

    public StockPriceDTO() {
    }

    private String stockSymbol;
    private double price;

    private String trend;

    public StockPriceDTO(String stockSymbol, double price, String trend) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.trend = trend;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
