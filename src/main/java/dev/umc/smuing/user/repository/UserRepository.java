package dev.umc.smuing.user.repository;

import dev.umc.smuing.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
