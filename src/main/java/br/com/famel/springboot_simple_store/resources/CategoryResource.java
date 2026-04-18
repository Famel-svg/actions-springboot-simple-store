package br.com.famel.springboot_simple_store.resources;
import br.com.famel.springboot_simple_store.entities.Category;
import br.com.famel.springboot_simple_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryResource {
    @Autowired private CategoryService service;
    @GetMapping public ResponseEntity<List<Category>> findAll() { return ResponseEntity.ok().body(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Category> findById(@PathVariable Long id) { return ResponseEntity.ok().body(service.findById(id)); }
}
