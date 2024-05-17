package com.aloysius.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSearchDTO {
    private String customerFullName;
    private  String customerAddress;
    private String  customerBirthDate;
}
