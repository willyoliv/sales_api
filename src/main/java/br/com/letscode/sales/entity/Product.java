package br.com.letscode.sales.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productCode;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    private Sale sale;
}
