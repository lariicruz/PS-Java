package br.com.supera.game.store.service;


import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDTO> findAll(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Product> list = productRepository.findAll(pageRequest);
        return new PageImpl<>(list.getContent().stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList()));
    }
}
