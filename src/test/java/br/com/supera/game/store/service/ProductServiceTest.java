package br.com.supera.game.store.service;

import br.com.supera.game.store.builder.ProductBuilder;
import br.com.supera.game.store.repository.ProductRepository;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    private ProductBuilder productBuilder;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productBuilder = new ProductBuilder();
    }

    @Test
    public void whenFindAllThenReturnProduct() {

        Integer page = 0;
        Integer linesPerPage = 10;
        String direction = "ASC";
        String orderBy = "name";

        given(productRepository.findAll((PageRequest) any())).willReturn(new PageImpl<>(Arrays.asList(productBuilder.getProduct())));
        productService.findAll(page, linesPerPage, orderBy, direction);

        verify(productRepository, VerificationModeFactory.times(1)).findAll((PageRequest) any());
    }

}
