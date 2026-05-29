package com.re.projcethackkathon011.repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByTitleContainingAndIsDeletedFalse(String title, Pageable pageable);

    Optional<Book> findByIdAndIsDeletedFalse(Long id);
}