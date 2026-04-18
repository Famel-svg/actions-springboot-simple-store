package br.com.famel.springboot_simple_store.resources;
import br.com.famel.springboot_simple_store.entities.Product;
import br.com.famel.springboot_simple_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {
    @Autowired private ProductService service;
    @GetMapping public ResponseEntity<List<Product>> findAll() { return ResponseEntity.ok().body(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Product> findById(@PathVariable Long id) { return ResponseEntity.ok().body(service.findById(id)); }
}
