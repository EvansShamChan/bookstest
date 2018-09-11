package com.esc.bookstest.repository;

import com.esc.bookstest.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select * from authors where year(born) < year(curdate()) - :age order by born", nativeQuery = true)
    List<Author> getAllAuthorsOlderThan(@Param("age") Integer age);

    @Query(value = "select * from authors where id in(select author_id from author_book group by author_id having count(*) > :bookNumber)", nativeQuery = true)
    List<Author> getAllAuthorsByBookNumberGreaterThan(@Param("bookNumber") Integer bookNumber);

    @Query(value = "select * from authors where id in(\n" +
            "select author_id from author_book group by author_id having count(*) = \n" +
            "(select count(*) as c from author_book group by author_id order by c desc limit 1))", nativeQuery = true)
    List<Author> getAuthorsByMostBookNumber();
}
