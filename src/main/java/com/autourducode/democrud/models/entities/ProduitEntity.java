package com.autourducode.democrud.models.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "produits")
@Data
public class ProduitEntity {
    @Id
    @GeneratedValue( generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column
    private Integer prix;
    @Column
    private String description;
}
