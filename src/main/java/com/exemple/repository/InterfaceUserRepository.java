package com.exemple.repository;

import com.exemple.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InterfaceUserRepository")
public interface InterfaceUserRepository extends JpaRepository<User,Long> {
}
