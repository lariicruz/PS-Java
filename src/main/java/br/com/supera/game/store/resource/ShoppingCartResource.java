package br.com.supera.game.store.resource;


import br.com.supera.game.store.service.ShoppingCartService;
import br.com.supera.game.store.service.dto.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/shopping-cart")
public class ShoppingCartResource {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ShoppingCartDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(shoppingCartService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> findAll() {
        return ResponseEntity.ok().body(shoppingCartService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> createShoppingCart(@Valid @RequestBody ShoppingCartDTO pedido) {
        Long id = shoppingCartService.createShoppingCart(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ShoppingCartDTO> updateShoppingCart(@PathVariable Long id, @Valid @RequestBody ShoppingCartDTO pedido) {
        return ResponseEntity.ok(shoppingCartService.updateShoppingCart(pedido, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletecreateShoppingCart(@PathVariable Long id) {
        shoppingCartService.deleteShoppingCart(id);
        return ResponseEntity.noContent().build();
    }

}
