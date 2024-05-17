package com.aloysius.rest.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mst_customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @javax.persistence.Id
    @Column(name = "customer_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String Id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(name = "address")
    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "UTC")
    private Date birthDate;

    @Column(name = "status")
    private String status;
}


