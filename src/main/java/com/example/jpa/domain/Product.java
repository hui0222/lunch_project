package com.example.jpa.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_info")
    private String productInfo;
}
