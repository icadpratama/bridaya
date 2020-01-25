package team.kasta.bridaya.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import team.kasta.bridaya.model.cashier.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
