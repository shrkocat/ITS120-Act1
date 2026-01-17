package com.santeco.pss.payload;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private String customerName;
    private List<Item> items;
    private double totalAmount;
    private long orderTimestamp;
}
