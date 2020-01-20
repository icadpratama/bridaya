package team.kasta.bridaya.service.impl;

import team.kasta.bridaya.model.authentication.User;
import team.kasta.bridaya.repository.UserRepository;
import team.kasta.bridaya.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean checkUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean checkUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User crateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> userListByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> userById(Long id) {
        return userRepository.findById(id);
    }
}
