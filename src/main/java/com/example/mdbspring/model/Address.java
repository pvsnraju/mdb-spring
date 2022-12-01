package com.example.mdbspring.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String address1;
    private String address2;
    private String city;
}
