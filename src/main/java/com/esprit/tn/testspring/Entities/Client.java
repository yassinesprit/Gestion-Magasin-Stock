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
import java.util.List;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@Entity
public class Client implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idClient;
    public String nom;
    public String prenom;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    public Date dateNaissance;
    public String email;
    public String password;
    @Enumerated(EnumType.STRING)
    public CategorieClient categorieClient;
    @Enumerated(EnumType.STRING)
    public Profession profession;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    public List<Facture> factures;
}
