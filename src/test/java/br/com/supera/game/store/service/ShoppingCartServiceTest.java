package br.com.supera.game.store.service;

import br.com.supera.game.store.builder.ProductBuilder;
import br.com.supera.game.store.builder.ShoppingCartBuilder;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {

    private ShoppingCartBuilder shoppingCartBuilder;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @MockBean
    private ShoppingCartRepository shoppingCartRepository;

    @Before
    public void setUp() {
        shoppingCartBuilder = new ShoppingCartBuilder();
    }

    @Test
    public void whenFindByIdThenReturnShoppingCart() {

        ShoppingCartDTO shoppingCartDTO = shoppingCartBuilder.getShoppingCartDTO();
        given(shoppingCartRepository.findById(shoppingCartBuilder.getShoppingCartDTO().getId())).willReturn(Optional.of(shoppingCartBuilder.getShoppingCart()));
        shoppingCartService.findById(shoppingCartDTO.getId());
        verify(shoppingCartRepository, VerificationModeFactory.times(1)).findById(any());
    }

    @Test
    public void whenFindAllThenReturnShoppingCart() {

        given(shoppingCartRepository.findAll()).willReturn(Arrays.asList(shoppingCartBuilder.getShoppingCart()));
        shoppingCartService.findAll();
        verify(shoppingCartRepository, VerificationModeFactory.times(1)).findAll();
    }

    @Test
    public void whenInsertThenReturnSucess() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartBuilder.getShoppingCartDTO();
        given(shoppingCartRepository.saveAndFlush(any())).willReturn(shoppingCartBuilder.getShoppingCart());
        shoppingCartService.createShoppingCart(shoppingCartDTO);
        verify(shoppingCartRepository, VerificationModeFactory.times(1)).saveAndFlush(any());
    }

    @Test
    public void whenUpdateThenReturnSucess() {

        ShoppingCartDTO shoppingCartDTO = shoppingCartBuilder.getShoppingCartDTO();
        given(shoppingCartRepository.saveAndFlush(any())).willReturn(shoppingCartBuilder.getShoppingCart());
        shoppingCartService.updateShoppingCart(shoppingCartDTO,shoppingCartDTO.getId());
        verify(shoppingCartRepository, VerificationModeFactory.times(1)).saveAndFlush(any());
    }


    @Test
    public void whenDeleteThenReturnSucess() {

        ShoppingCart shoppingCart = shoppingCartBuilder.getShoppingCart();
        given(shoppingCartRepository.findById(shoppingCart.getId())).willReturn(Optional.of(shoppingCart));
        doNothing().when(shoppingCartRepository).delete(any());
        shoppingCartService.deleteShoppingCart(shoppingCart.getId());
        verify(shoppingCartRepository, VerificationModeFactory.times(1)).deleteById(shoppingCart.getId());
    }

}
