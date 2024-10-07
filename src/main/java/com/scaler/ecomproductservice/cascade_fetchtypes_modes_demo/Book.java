package com.scaler.ecomproductservice.cascade_fetchtypes_modes_demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    public Author author;
}
