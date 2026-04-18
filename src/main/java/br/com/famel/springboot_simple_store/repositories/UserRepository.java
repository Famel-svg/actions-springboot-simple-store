package br.com.famel.springboot_simple_store.repositories;
import br.com.famel.springboot_simple_store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {}
