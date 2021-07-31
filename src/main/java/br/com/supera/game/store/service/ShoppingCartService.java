package br.com.supera.game.store.service;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.enums.StatusEnum;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import br.com.supera.game.store.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemService itemService;

    public ShoppingCartDTO findById(Long id) {
        ShoppingCart obj = shoppingCartRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Registro não encontrado"));
        return new ShoppingCartDTO(obj);
    }

    public List<ShoppingCartDTO> findAll() {
        return shoppingCartRepository.findAll().stream().map(obj -> new ShoppingCartDTO(obj)).collect(Collectors.toList());
    }

    public Long createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartDTO.setId(null);
        shoppingCartDTO.setStatusEnum(StatusEnum.PENDENTE);
        calcShoppingCart(shoppingCartDTO);

        ShoppingCart obj = new ShoppingCart(shoppingCartDTO);

        obj = shoppingCartRepository.saveAndFlush(obj);

        itemService.saveAll(shoppingCartDTO.getItens(), obj);

        return obj.getId();

    }

    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO shoppingCartDTO, Long id) {
        shoppingCartDTO.setId(id);
        calcShoppingCart(shoppingCartDTO);

        ShoppingCart obj = new ShoppingCart(shoppingCartDTO);
        obj = shoppingCartRepository.saveAndFlush(obj);

        obj.setItens(itemService.saveAll(shoppingCartDTO.getItens(), obj));
        return new ShoppingCartDTO(obj);
    }

    public void deletecreateShoppingCart(Long id) {
        findById(id);
        shoppingCartRepository.deleteById(id);
    }

    private void calcShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartDTO.getItens().stream().forEach(obj -> {
            if (obj.getPrice().compareTo(new BigDecimal(250.0)) < 0) {
                shoppingCartDTO.setShipping(shoppingCartDTO.getShipping().add(BigDecimal.TEN));
            }
            shoppingCartDTO.setSubtotal(shoppingCartDTO.getSubtotal().add(obj.getProduct().getPrice()));
        });
        shoppingCartDTO.setTotal(shoppingCartDTO.getTotal().add(shoppingCartDTO.getSubtotal()).add(shoppingCartDTO.getShipping()));
    }

}