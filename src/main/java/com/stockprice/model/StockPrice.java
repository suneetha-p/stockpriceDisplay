package com.stockprice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;




@Entity(name = "StockPrice")
@Table(name="STOCKPRICE")

public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;
    @Column(name="STOCK_SYMBOL")
    private String stockSymbol;
    @Column(name="BIDPRICE")
    private  double bidPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public StockPrice() {
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "id=" + id +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", bidPrice=" + bidPrice +
                ", price=" + "price" +
                ", trend='" + "trend" + '\'' +
                ", askPrice=" + askPrice +
                ", eventTime=" + eventTime +
                '}';
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }
    @Column(name="ASKPRICE")
    private double askPrice;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp eventTime;

    
}
