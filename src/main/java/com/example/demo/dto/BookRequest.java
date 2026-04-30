package com.example.demo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data

public class BookRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 2, max=150)
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotNull(message = "Publication year is required")
    private Integer publicationYear;

    @NotNull(message = "Category id is required")
    private Long categoryId;
}
