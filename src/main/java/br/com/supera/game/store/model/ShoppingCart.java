package br.com.supera.game.store.model;

import br.com.supera.game.store.model.enums.StatusEnum;
import br.com.supera.game.store.service.dto.ItemDTO;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal shipping;
    private BigDecimal subtotal;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Item> itens = new ArrayList<>();

    public ShoppingCart(ShoppingCartDTO shoppingCart) {
        this.id = shoppingCart.getId();
        this.shipping = shoppingCart.getShipping();
        this.subtotal = shoppingCart.getSubtotal();
        this.total = shoppingCart.getTotal();
        this.statusEnum = shoppingCart.getStatusEnum();
        this.itens = shoppingCart.getItens().stream().map(item -> new Item(item)).collect(Collectors.toList());
    }

}
