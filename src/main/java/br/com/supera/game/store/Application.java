package br.com.supera.game.store;

import br.com.supera.game.store.model.Item;
import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.enums.StatusEnum;
import br.com.supera.game.store.repository.ItemRepository;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemRepository itemRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public boolean intastianteDatabase() {

        System.out.println("Salvar produtos");

        Product jogoUm = new Product(1L, "Produto 1", new BigDecimal(250.0), (short) 5.0, "imagem-produto1.jpg", null);
        Product jogoDois = new Product(2L, "Produto 2 ", new BigDecimal(220.0), (short) 4.0, "imagem-produto2.jpg", null);
        Product jogoTres = new Product(3L, "Produto 3", new BigDecimal(210.0), (short) 4.5, "imagem-produto3.jpg", null);

        productRepository.saveAll(Arrays.asList(jogoUm, jogoDois, jogoTres));

        System.out.println("Salvar Carrinho de compra");

        ShoppingCart shoppingCart = new ShoppingCart(1L, new BigDecimal(0), new BigDecimal(220.0), new BigDecimal(220.0), StatusEnum.PENDENTE, new ArrayList<>() );

        shoppingCart = shoppingCartRepository.saveAndFlush(shoppingCart);

        Item item1 = new Item(1L, jogoUm.getPrice(), shoppingCart, jogoUm);
        Item item2 = new Item(2L, jogoDois.getPrice(), shoppingCart, jogoDois);
        Item item3 = new Item(3L, jogoTres.getPrice(), shoppingCart, jogoTres);

        itemRepository.saveAll(Arrays.asList(item1,item2,item3));

        System.out.println("Fim da carga inicial");

        return true;
    }

}
