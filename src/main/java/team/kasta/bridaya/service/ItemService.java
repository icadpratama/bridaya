package team.kasta.bridaya.service;

import team.kasta.bridaya.model.cashier.Item;

import java.util.Optional;

public interface ItemService {

    Item createItem(Item item);
    Item updateStock(Item item);
    Optional<Item> itemListByBusinessId(Long id);
}
