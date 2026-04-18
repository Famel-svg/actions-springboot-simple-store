package br.com.famel.springboot_simple_store.repositories;
import br.com.famel.springboot_simple_store.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long> {}
