package team.kasta.bridaya.service;

import team.kasta.bridaya.model.authentication.Role;
import team.kasta.bridaya.util.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> setRole(RoleName name);
}
