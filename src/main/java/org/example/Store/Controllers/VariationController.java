package org.example.Store.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Store.Models.Variation;
import org.example.Store.Services.VariationService;
import org.example.Store.Services.VariationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api/variation")
@RequiredArgsConstructor
@Slf4j
public class VariationController {
    private final VariationServiceImpl variationService;


    @GetMapping
    public ResponseEntity<Collection<Variation>> getAll(){
        return ResponseEntity.ok().body(variationService.index());
    }
    @PostMapping
    public ResponseEntity<?> store() throws Exception {
        try{
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/variation").toUriString());
            return ResponseEntity.created(uri).body(variationService.store());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
