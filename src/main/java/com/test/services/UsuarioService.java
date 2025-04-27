package com.test.services;

public class UsuarioService {

    private final UserRepository userRepository;

    public UsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String name){
        return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
