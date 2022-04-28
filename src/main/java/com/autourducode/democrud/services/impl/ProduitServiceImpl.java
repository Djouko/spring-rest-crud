package com.autourducode.democrud.services.impl;

import com.autourducode.democrud.configs.exceptions.MyException;
import com.autourducode.democrud.configs.exceptions.MyExceptionPayLoad;
import com.autourducode.democrud.models.dto.ProduitDto;
import com.autourducode.democrud.models.entities.ProduitEntity;
import com.autourducode.democrud.repositories.ProduitRepository;
import com.autourducode.democrud.services.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public ProduitDto createProduit(ProduitDto produitDto) {
        ProduitEntity produit = new ProduitEntity();
        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit = produitRepository.save(produit);
        return ProduitDto.builder()
                .id(produit.getId())
                .prix(produit.getPrix())
                .description(produit.getDescription())
                .build();
    }

    @Override
    public List<ProduitDto> readProduit() {
        List<ProduitEntity> produits = produitRepository.findAll();
        List<ProduitDto> produitDtos = new ArrayList<>();
        produits.stream()
                .map(p -> ProduitDto.builder()
                        .id(p.getId())
                        .description(p.getDescription())
                        .prix(p.getPrix())
                        .build()).forEach(produitDtos::add);
        return produitDtos;
    }

    @Override
    public ProduitDto updateProduit(String id, ProduitDto produitDto) {
        return produitRepository.findById(id)
                .map(p -> {
                    p.setPrix(produitDto.getPrix());
                    p.setDescription(produitDto.getDescription());
                    produitRepository.save(p);
                    produitDto.setId(p.getId());
                    return produitDto;
                }).orElse(null);
    }

    @Override
    public String deleteProduit(String id) {
        ProduitEntity p = produitRepository.findById(id)
                .orElseThrow(() -> new MyException(
                        MyExceptionPayLoad.builder()
                                .httpCode(404)
                                .message("Produit non trouvé")
                                .build()
                ));
        produitRepository.delete(p);
        return "Produit supprimé !";
    }
}
