package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SaleService {

    private final SaleRepository saleRepository;

    private final SellerRepository sellerRepository;

    private final ModelMapper modelMapper;

    @Transactional(readOnly = true) //todas as transações de BD serão resolvidas nessa camada (service)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); //JPA busca e armazena em memória (ideal para repetir iterações e quando se tem poucos registros)
        Page<Sale> sales = saleRepository.findAll(pageable);
        return sales.map(sale -> modelMapper.map(sale, SaleDTO.class));
    }

}
