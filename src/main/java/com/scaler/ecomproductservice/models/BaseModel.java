package com.scaler.ecomproductservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel
{
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @Column(name = "id", columnDefinition = "UUID", nullable = false, updatable = false)
    protected UUID id;
}
