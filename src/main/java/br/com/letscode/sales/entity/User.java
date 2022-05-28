package br.com.letscode.sales.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userCode;
    private String userName;
    private String role;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Sale sale;
}
