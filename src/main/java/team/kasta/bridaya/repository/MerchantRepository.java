package team.kasta.bridaya.repository;

import org.springframework.data.repository.CrudRepository;
import team.kasta.bridaya.model.common.Merchant;

public interface MerchantRepository extends CrudRepository<Merchant, Long> {
}
