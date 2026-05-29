package com.re.projcethackkathon011.service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    private BookResponse mapToResponse(Book b) {
        BookResponse r = new BookResponse();
        r.setId(b.getId());
        r.setTitle(b.getTitle());
        r.setAuthor(b.getAuthor());
        r.setPrice(b.getPrice());
        r.setStatus(b.getStatus().name());
        return r;
    }

    @Override
    public BookResponse create(BookRequest req) {
        Book b = new Book();
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setPrice(req.getPrice());
        b.setStatus(req.getStatus());

        return mapToResponse(repo.save(b));
    }

    @Override
    public Page<BookResponse> getAll(String keyword, Pageable pageable) {
        return repo.findByTitleContainingAndIsDeletedFalse(keyword, pageable)
                .map(this::mapToResponse);
    }

    @Override
    public BookResponse update(Long id, BookRequest req) {
        Book b = repo.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setPrice(req.getPrice());
        b.setStatus(req.getStatus());

        return mapToResponse(repo.save(b));
    }

    @Override
    public BookResponse patch(Long id, Map<String, Object> updates) {
        Book b = repo.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (updates.containsKey("title")) {
            b.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("author")) {
            b.setAuthor((String) updates.get("author"));
        }

        return mapToResponse(repo.save(b));
    }

    @Override
    public void delete(Long id) {
        Book b = repo.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        b.setDeleted(true); // soft delete
        repo.save(b);
    }
}