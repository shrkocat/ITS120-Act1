package com.santeco.pss.payload;

import lombok.Data;

@Data
public class Item {
    private int productId;
    private String itemName;
    private int quantity;
    private double unitPrice;
    private String uom;
}
