package br.com.supera.game.store.builder;

import br.com.supera.game.store.model.Item;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.enums.StatusEnum;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class ShoppingCartBuilder {

    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(1L, new BigDecimal(0), new BigDecimal(220.0), new BigDecimal(220.0), StatusEnum.PENDENTE, getListItens());
    }

    public ShoppingCartDTO getShoppingCartDTO() {
        return new ShoppingCartDTO(getShoppingCart());
    }

    public List<ShoppingCartDTO> getListShoppingCartDTO() {
        return Arrays.asList(getShoppingCartDTO());
    }

    public List<ShoppingCart> getListShoppingCart() {
        return Arrays.asList(getShoppingCart());
    }

    private List<Item> getListItens() {
        return Arrays.asList(
                new Item(1L, new BigDecimal(197.88), null, new Product(1L, "Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png", null)),
                new Item(2L, new BigDecimal(197.88), null, new Product(1L, "Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png", null)),
                new Item(3L, new BigDecimal(197.88), null, new Product(1L, "Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png", null)),
                new Item(4L, new BigDecimal(197.88), null, new Product(1L, "Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png", null))
        );
    }
}