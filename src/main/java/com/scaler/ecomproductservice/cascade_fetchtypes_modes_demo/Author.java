package com.scaler.ecomproductservice.cascade_fetchtypes_modes_demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    public List<Book> books;
}
