package uz.pdp.SpringDataJpaTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.SpringDataJpaTest.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findFirstByUsernameAndPassword(String username, String password);
    Optional<User> findFirstByUsername(String username);
}
