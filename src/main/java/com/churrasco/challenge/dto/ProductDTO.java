package com.churrasco.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    private Integer id;
    @NotNull(message = "SKU must not be null")
    private Long SKU;
    @NotNull(message = "Code must not be null")
    private Integer code;
    @NotBlank(message = "Name must not be blank")
    private String name;
    private String description;
    private String picture;
    @NotNull(message = "Price must not be null")
    private BigDecimal price;
    private String currency;

}
