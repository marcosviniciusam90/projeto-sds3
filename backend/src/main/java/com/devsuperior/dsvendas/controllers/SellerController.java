package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SellerController {

    private final SellerService sellerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDTO> findAll() {
        return sellerService.findAll();
    }
}
