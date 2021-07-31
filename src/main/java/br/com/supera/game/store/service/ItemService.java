package br.com.supera.game.store.service;


import br.com.supera.game.store.model.Item;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.ItemRepository;
import br.com.supera.game.store.service.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> saveAll(List<ItemDTO> itensDTO, ShoppingCart shoppingCart) {

        List<Item> itens = itensDTO.stream().map(obj-> new Item(obj)).collect(Collectors.toList());

        removeAll(shoppingCart);
        addValueProduct(itens, shoppingCart);
        return itemRepository.saveAll(itens);
    }

    private void addValueProduct(List<Item> itens, ShoppingCart shoppingCart) {
        itens.stream().forEach(obj -> {
            obj.setPrice(obj.getProduct().getPrice());
            obj.setShoppingCart(shoppingCart);
        });
    }

    private void removeAll(ShoppingCart shoppingCart) {
        itemRepository.deleteByShoppingCartId(shoppingCart.getId());
    }
}
