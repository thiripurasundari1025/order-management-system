package com.order.management.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="shelf_life")
    private int shelfLife;

    @Column(name="label_num")
    private int labelNum;


    @Column(name="num_per_pallet_layer")
    private int numPerPalletLayer;
 
    
    @Column(name="num_per_pallet")
    private int numPerPallet;

    @Column(name="ten_liter_per_pack")
    private Double tenLiterPerPack;

    @Column(name="sales_price_retail")
    private Double salesPriceRetail;

    @Column(name="amount_orange")
    private Double amountOrange;

    @Column(name="amount_mango")
    private Double amountMango;

    @Column(name="amount_vitamin_c")
    private Double amountVitamin_c;

    @Column(name="amount_water")
    private Double amountWater;

}