package br.com.famel.springboot_simple_store.resources;
import br.com.famel.springboot_simple_store.entities.Order;
import br.com.famel.springboot_simple_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    @Autowired private OrderService service;
    @GetMapping public ResponseEntity<List<Order>> findAll() { return ResponseEntity.ok().body(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Order> findById(@PathVariable Long id) { return ResponseEntity.ok().body(service.findById(id)); }
}
