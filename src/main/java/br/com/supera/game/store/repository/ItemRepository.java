package br.com.supera.game.store.repository;


import br.com.supera.game.store.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {


    void deleteByShoppingCartId(Long id);
}
