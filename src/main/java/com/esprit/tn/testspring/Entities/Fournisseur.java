package com.esprit.tn.testspring.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class Fournisseur implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idFournisseur;
    public String codeFournisseur;
    public String libelleFournisseur;
}
