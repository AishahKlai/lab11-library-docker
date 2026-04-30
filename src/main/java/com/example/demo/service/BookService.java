package com.example.demo.service;

import com.example.demo.dto.BookRequest;
import com.example.demo.dto.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookResponse createBook(BookRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId()));

        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .publicationYear(request.getPublicationYear())
                .category(category)
                .build();

        Book saved =bookRepository.save(book);
        log.info("Book created with id: {}", saved.getId());
        return BookResponse.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .author(saved.getAuthor())
                .categoryId(category.getId())
                .categoryName(category.getName())
                .build();
    }
}
