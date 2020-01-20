package team.kasta.bridaya.service.impl;

import team.kasta.bridaya.model.authentication.Role;
import team.kasta.bridaya.repository.RoleRepository;
import team.kasta.bridaya.service.RoleService;
import team.kasta.bridaya.util.RoleName;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> setRole(RoleName name) {
        return roleRepository.findByName(name);
    }
}
