package br.com.supera.game.store.service.dto;

import br.com.supera.game.store.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Short score;
    private String image;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.score = product.getScore();
        this.image = product.getImage();
    }
}