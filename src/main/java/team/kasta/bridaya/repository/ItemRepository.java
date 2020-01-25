package team.kasta.bridaya.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import team.kasta.bridaya.model.cashier.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
