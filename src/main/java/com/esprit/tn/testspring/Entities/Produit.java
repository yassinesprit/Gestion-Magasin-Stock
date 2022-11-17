package com.esprit.tn.testspring.Entities;

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
public class Produit implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idProduit;
    public String codeProduit;
    public String libelleProduit;
    public float prixProduit;
    @ManyToMany
    public List<Fournisseur> fournisseurs;
    @ManyToOne
    public Rayon rayon;
    @ManyToOne
    public Stock stock;
    @OneToOne(cascade = CascadeType.PERSIST)
    public DetailProduit detailProduit;
    @OneToMany(mappedBy = "produit")
    public List<DetailFacture> detailFactures;
}
