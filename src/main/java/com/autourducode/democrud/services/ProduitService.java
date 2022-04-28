package com.autourducode.democrud.services;

import com.autourducode.democrud.models.dto.ProduitDto;

import java.util.List;

public interface ProduitService {
    ProduitDto createProduit(final ProduitDto produitDto);
    List<ProduitDto> readProduit();
    ProduitDto updateProduit(final String id, final ProduitDto  produitDto);
    String deleteProduit(String id);
}
