package com.esprit.tn.testspring.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class DetailFacture implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idDetailFacture;
    public int qte;
    public float prixTotal;
    public int pourcentageRemise;
    public int montantRemise;
    @ManyToOne
    public Produit produit;
    @ManyToOne
    public Facture facture;
}
