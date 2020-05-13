package edu.miu.cs544.team6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.miu.cs544.team6.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmailEquals(String email);
}
