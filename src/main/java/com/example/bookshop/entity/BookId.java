package com.example.bookshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BookId implements Serializable {
    private int id;
    private String isbn;
}
