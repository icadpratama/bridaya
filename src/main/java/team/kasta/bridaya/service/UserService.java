package team.kasta.bridaya.service;

import team.kasta.bridaya.model.authentication.User;

import java.util.Optional;

public interface UserService {

    Boolean checkUserByUsername(String username);
    Boolean checkUserByEmail(String email);
    User crateUser(User user);
    Optional<User> userListByUsername(String username);
    Optional<User> userById(Long id);
}
