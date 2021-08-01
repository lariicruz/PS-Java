package br.com.supera.game.store.resource;


import br.com.supera.game.store.builder.ShoppingCartBuilder;
import br.com.supera.game.store.resource.util.TestUtil;
import br.com.supera.game.store.service.ShoppingCartService;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import br.com.supera.game.store.service.exception.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartResource.class)
public class ShoppingCartResourceTest {

    public static final String BASE_URL = "/shopping-cart";

    @Autowired
    private MockMvc mvc;

    private ShoppingCartBuilder shoppingCartBuilder;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        shoppingCartBuilder = new ShoppingCartBuilder();
    }

    @Test
    public void whenFindAllShoppingCartThenReturnStatusOk() throws Exception {

        given(shoppingCartService.findAll()).willReturn(null);
        mvc.perform(get(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(shoppingCartService, VerificationModeFactory.times(1)).findAll();
        reset(shoppingCartService);
    }

    @Test
    public void whenInsertShoppingCartThenReturnStatusCreate() throws Exception {

        ShoppingCartDTO obj = shoppingCartBuilder.getShoppingCartDTO();
        given(shoppingCartService.createShoppingCart(any())).willReturn(obj.getId());
        mvc.perform(post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.toJson(obj)))
                .andExpect(status().isCreated());

        verify(shoppingCartService, VerificationModeFactory.times(1)).createShoppingCart(any());
        reset(shoppingCartService);
    }

    @Test
    public void whenUpdateShoppingCartThenReturnStatusCreate() throws Exception {

        ShoppingCartDTO obj = shoppingCartBuilder.getShoppingCartDTO();
        given(shoppingCartService.updateShoppingCart(any(), any())).willReturn(obj);

        mvc.perform(put(BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.toJson(obj)))
                .andExpect(status().isOk());

        verify(shoppingCartService, VerificationModeFactory.times(1)).updateShoppingCart(any(), any());
        reset(shoppingCartService);
    }

    @Test
    public void whenFindByIdShoppingCartThenReturnStatusOk() throws Exception {

        given(shoppingCartService.findById(any())).willReturn(shoppingCartBuilder.getShoppingCartDTO());
        mvc.perform(get(BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(shoppingCartService, VerificationModeFactory.times(1)).findById(any());
        reset(shoppingCartService);
    }


    @Test
    public void whenDeleteByIdShoppingCartThenReturnStatusOk() throws Exception {

        doNothing().when(shoppingCartService).deleteShoppingCart(any());
        mvc.perform(delete(BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(shoppingCartService, VerificationModeFactory.times(1)).deleteShoppingCart(any());
        reset(shoppingCartService);
    }


    @Test
    public void whenFindByIdShoppingCartThenReturnErrorNotFound() throws Exception {

        given(shoppingCartService.findById(any())).willThrow(new ObjectNotFoundException("Registro não encontrado"));
        mvc.perform(get(BASE_URL + "/54654")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(shoppingCartService, VerificationModeFactory.times(1)).findById(any());
        reset(shoppingCartService);
    }


}