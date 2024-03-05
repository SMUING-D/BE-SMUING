package dev.umc.smuing.user.repository;

import dev.umc.smuing.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByStudentId(String studentId);
}
