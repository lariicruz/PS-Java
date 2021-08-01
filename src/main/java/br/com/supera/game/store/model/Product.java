package br.com.supera.game.store.model;

import br.com.supera.game.store.service.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private BigDecimal price; // valor atual do produto no dia da compra

   private Short score;

   private String image;

   @JsonIgnore
   @OneToMany(mappedBy = "product")
   private List<Item> itens = new ArrayList<>();

   public Product(ProductDTO product) {
      this.id = product.getId();
      this.name = product.getName();
      this.price = product.getPrice();
      this.score = product.getScore();
      this.image = product.getImage();
   }

}