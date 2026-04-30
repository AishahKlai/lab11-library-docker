package com.example.demo.dto;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Data
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private Long categoryId;
    private String categoryName;

}
