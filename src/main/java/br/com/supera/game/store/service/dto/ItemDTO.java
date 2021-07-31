package br.com.supera.game.store.service.dto;

import br.com.supera.game.store.model.Item;
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
public class ItemDTO {
    private Long id;
    private BigDecimal price;
    private ProductDTO product;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.price = item.getPrice();
        this.product = new ProductDTO(item.getProduct());
    }
}

