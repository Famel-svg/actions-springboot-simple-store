package br.com.famel.springboot_simple_store.repositories;
import br.com.famel.springboot_simple_store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {}
