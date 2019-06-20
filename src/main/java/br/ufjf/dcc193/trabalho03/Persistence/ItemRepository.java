package br.ufjf.dcc193.trabalho03.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;


import br.ufjf.dcc193.trabalho03.Models.Item;

/**
 * ItemRepository
 */
public interface ItemRepository extends JpaRepository<Item, Long>{

    
}