package com.esprit.tn.testspring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class DetailProduit implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idDetailProduit;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    public Date dateCreation;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    public Date dateDerniereModification;
    @Enumerated(EnumType.STRING)
    public CategorieProduit categorieProduit;
    @JsonIgnore
    @OneToOne(mappedBy = "detailProduit")
    public Produit produit;
}
