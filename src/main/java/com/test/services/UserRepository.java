package com.test.services;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findByName(String name);
}
