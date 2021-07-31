package br.com.supera.game.store.model;

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
   public long id;

   public String name;

   public BigDecimal price;

   public short score;

   public String image;

   @JsonIgnore
   @OneToMany(mappedBy = "product")
   private List<Item> itens = new ArrayList<>();

}