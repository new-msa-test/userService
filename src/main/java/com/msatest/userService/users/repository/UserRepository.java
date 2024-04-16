package com.msatest.userService.users.repository;

import com.msatest.userService.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>{
}
