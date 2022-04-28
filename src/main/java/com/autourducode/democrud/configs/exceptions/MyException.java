package com.autourducode.democrud.configs.exceptions;

import lombok.*;

/**
 * @author autourducode
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class MyException extends RuntimeException{
    private MyExceptionPayLoad payLoad;
}
