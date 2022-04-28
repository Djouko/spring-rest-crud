package com.autourducode.democrud.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
public class ProduitDto {
    private String id;
    private Integer prix;
    private String description;
}
