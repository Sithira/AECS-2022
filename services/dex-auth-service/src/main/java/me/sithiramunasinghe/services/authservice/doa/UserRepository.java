package me.sithiramunasinghe.services.authservice.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where upper(u.username) like upper(?1)")
    Optional<User> findByUsername(@NonNull String username);
}
