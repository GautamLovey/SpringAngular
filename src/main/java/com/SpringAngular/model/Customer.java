package com.SpringAngular.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    String customerId;
    String customerFirstName;
    String customerLastName;
    String customerAddress;
    String customerPhoneNo;
}
