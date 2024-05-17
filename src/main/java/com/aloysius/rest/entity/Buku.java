package com.aloysius.rest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_buku")
@Getter
@Setter
@NoArgsConstructor
public class Buku {
    @Id
    @Column(name = "buku_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;


    @Column(nullable = false)
    private String bukuName;

    @Column(nullable = false)
    private Integer bukuPrice;

    @Column(nullable = false)
    private Integer stock;
}
