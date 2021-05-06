package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SaleDTO> findAll(Pageable pageable) {
        return saleService.findAll(pageable);
    }
}
