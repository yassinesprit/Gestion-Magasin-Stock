package com.esprit.tn.testspring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class Stock implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idStock;
    public int qteStock;
    public int qteMin;
    public String libelleStock;
    @OneToMany(mappedBy = "stock")
    @JsonIgnore
    public List<Produit> produits;
}
