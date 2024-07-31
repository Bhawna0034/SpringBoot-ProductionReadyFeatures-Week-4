package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@Audited
public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @PrePersist
    void beforeSave(){

    }

    @PreUpdate
    void beforeUpdate(){

    }

    @PreRemove
    void beforeRemove(){

    }



}

