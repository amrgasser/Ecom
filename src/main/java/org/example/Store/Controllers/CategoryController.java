package org.example.Store.Controllers;

import lombok.AllArgsConstructor;
import org.example.Store.Models.Category;
import org.example.Store.Services.CategoryService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> index (){
        return ResponseEntity.ok().body((List<Category>) categoryService.getAll());
    }

    @GetMapping("/subcategories/{id}")
    public ResponseEntity<List<Category>> findAllSubCategories(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.findAllSubCategories(id));
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody Category category){
        try{
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/category").toUriString());
            return ResponseEntity.created(uri).body(categoryService.store(category));
        }catch(DuplicateKeyException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
