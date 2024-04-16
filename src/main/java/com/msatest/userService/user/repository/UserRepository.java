package com.msatest.userService.user.repository;

import com.msatest.userService.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>{
}
