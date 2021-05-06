package com.devsuperior.dsvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO implements Serializable {

    private Long id;
    private String name;
}
