package team.kasta.bridaya.repository;

import team.kasta.bridaya.model.authentication.Role;
import team.kasta.bridaya.util.RoleName;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
