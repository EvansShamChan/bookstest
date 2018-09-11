package com.esc.bookstest.repository;

import com.esc.bookstest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select count(*) as number from books where genre = :genre group by genre", nativeQuery = true)
    Integer getNumberOfBooksByGenre(@Param("genre") String genre);
}
