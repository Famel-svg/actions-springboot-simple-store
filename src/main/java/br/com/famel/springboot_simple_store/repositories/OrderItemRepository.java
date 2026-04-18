package br.com.famel.springboot_simple_store.repositories;
import br.com.famel.springboot_simple_store.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
