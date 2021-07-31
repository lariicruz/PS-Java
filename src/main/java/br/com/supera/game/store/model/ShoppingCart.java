package br.com.supera.game.store.model;

import br.com.supera.game.store.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double frete;
    private Double subtotal;
    private Double total;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.REMOVE)
    private List<Item> itens = new ArrayList<>();

}
