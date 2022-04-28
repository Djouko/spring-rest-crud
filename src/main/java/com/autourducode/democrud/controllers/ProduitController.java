package com.autourducode.democrud.controllers;

import com.autourducode.democrud.models.dto.ProduitDto;
import com.autourducode.democrud.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {

    private ProduitService produitService;

    @PostMapping("/create")
    public ProduitDto createProduit(@RequestBody ProduitDto produitDto) {
        return produitService.createProduit(produitDto);
    }

    @GetMapping("/read")
    public List<ProduitDto> readProduit() {
        return produitService.readProduit();
    }

    @PutMapping("/update/{id}")
    public ProduitDto updateProduit(@PathVariable String id, @RequestBody ProduitDto produitDto) {
        return produitService.updateProduit(id, produitDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduit(@PathVariable String id) {
        return produitService.deleteProduit(id);
    }
}
