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
public class Rayon implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idRayon;
    public String codeRayon;
    public String libelleRayon;
    @OneToMany(mappedBy = "rayon")
    @JsonIgnore
    public List<Produit> produits;
}
