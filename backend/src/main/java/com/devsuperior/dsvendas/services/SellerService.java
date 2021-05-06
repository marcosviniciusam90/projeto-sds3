package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SellerService {

    private final SellerRepository sellerRepository;

    private final ModelMapper modelMapper;

    public List<SellerDTO> findAll() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers
                .stream()
                .map(seller -> modelMapper.map(seller, SellerDTO.class))
                .collect(Collectors.toList());
    }

}
