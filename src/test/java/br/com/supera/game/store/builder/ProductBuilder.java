package br.com.supera.game.store.builder;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.service.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductBuilder {

    public Product getProduct() {
        return new Product(1L, "Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png", null);
    }

    public List<Product> getListProduct() {
        return Arrays.asList(getProduct());
    }

    public ProductDTO getProductDTO() {
        return new ProductDTO(getProduct());
    }

    public List<ProductDTO> getListProductDTO() {
        return Arrays.asList(getProductDTO());
    }

}