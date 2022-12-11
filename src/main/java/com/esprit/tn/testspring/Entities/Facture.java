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
public class Facture implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idFacture;
    public float montantRemise;
    public float montantFacture;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    public Date dateFacture;
    public boolean active;
    @ManyToOne
    public Client client;
    @OneToMany(mappedBy = "facture")
    @JsonIgnore
    public List<DetailFacture> detailFactures;
}
