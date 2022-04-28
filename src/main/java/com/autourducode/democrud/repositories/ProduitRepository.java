package com.autourducode.democrud.repositories;

import com.autourducode.democrud.models.entities.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<ProduitEntity, String> {
}
