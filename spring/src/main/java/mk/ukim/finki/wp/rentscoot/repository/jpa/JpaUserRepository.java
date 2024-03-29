package mk.ukim.finki.wp.rentscoot.repository.jpa;

import mk.ukim.finki.wp.rentscoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailOrNameOrderByName(String email,String name);
    User getUserByEmail(String email);
}
