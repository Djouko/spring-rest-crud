package com.autourducode.democrud.configs.exceptions;

import lombok.*;

import java.io.Serializable;

/**
 * @author autourducode
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class MyExceptionPayLoad {
    private Integer httpCode;
    private String message;
}
