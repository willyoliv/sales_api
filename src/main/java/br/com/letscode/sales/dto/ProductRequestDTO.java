package br.com.letscode.sales.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductRequestDTO {

    @NotNull(message = "The productCode field cannot be empty or null")
    private Long productCode;

    @NotEmpty(message = "The name field cannot be empty or null")
    private String name;

    @NotEmpty(message = "The description field cannot be empty or null")
    private String description;

    @NotEmpty(message = "The category field cannot be empty or null")
    private String category;

    @NotNull(message = "The price field cannot be empty or null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Double price;

    @NotNull(message = "The quantity field cannot be empty or null")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
}
