package br.com.supera.game.store.resource;

import br.com.supera.game.store.builder.ProductBuilder;
import br.com.supera.game.store.service.ProductService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductResource.class)
public class ProductResourceTest {

    public static final String BASE_URL = "/product";

    @Autowired
    private MockMvc mvc;

    private ProductBuilder productBuilder;

    @MockBean
    private ProductService productService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        productBuilder = new ProductBuilder();
    }


    @Test
    public void whenFindAllProductThenReturnStatusOk() throws Exception {

        given(productService.findAll(any(), any(), any(), any())).willReturn(null);

        mvc.perform(get(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(productService, VerificationModeFactory.times(1)).findAll(any(), any(), any(), any());
        reset(productService);
    }

}
