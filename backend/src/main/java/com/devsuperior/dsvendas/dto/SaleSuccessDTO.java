package com.devsuperior.dsvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleSuccessDTO implements Serializable {
    private String sellerName;
    private Long visited;
    private Long deals;
}
