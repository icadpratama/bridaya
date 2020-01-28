package team.kasta.bridaya.service.impl;

import org.springframework.stereotype.Service;
import team.kasta.bridaya.model.cashier.Item;
import team.kasta.bridaya.repository.ItemRepository;
import team.kasta.bridaya.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item request) {
        return itemRepository.save(request);
    }
}
