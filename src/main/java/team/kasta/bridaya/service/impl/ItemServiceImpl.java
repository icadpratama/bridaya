package team.kasta.bridaya.service.impl;

import org.springframework.stereotype.Service;
import team.kasta.bridaya.model.cashier.Item;
import team.kasta.bridaya.repository.ItemRepository;
import team.kasta.bridaya.service.ItemService;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateStock(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> itemListByBusinessId(Long id) {
        return Optional.empty();
    }
}
