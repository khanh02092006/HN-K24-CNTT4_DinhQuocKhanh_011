package com.re.projcethackkathon011.service.impl;

public interface BookService {

    BookResponse create(BookRequest request);

    Page<BookResponse> getAll(String keyword, Pageable pageable);

    BookResponse update(Long id, BookRequest request);

    BookResponse patch(Long id, Map<String, Object> updates);

    void delete(Long id);
}