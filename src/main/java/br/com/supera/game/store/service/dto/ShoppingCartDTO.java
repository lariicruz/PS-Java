package br.com.supera.game.store.service.dto;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShoppingCartDTO {

    private Long id;
    private BigDecimal shipping = BigDecimal.ZERO;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private StatusEnum statusEnum;
    private List<ItemDTO> itens = new ArrayList<>();

    public ShoppingCartDTO(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.shipping = shoppingCart.getShipping();
        this.subtotal = shoppingCart.getSubtotal();
        this.total = shoppingCart.getTotal();
        this.statusEnum = shoppingCart.getStatusEnum();
        this.itens = shoppingCart.getItens().stream().map(item -> Objects.nonNull(item.getId()) ? new ItemDTO(item) : null).collect(Collectors.toList());
    }
}
