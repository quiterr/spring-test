package com.quiterr.mongo;

import com.quiterr.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by Huangchen on 2017/5/17.
 */
public interface  BookRepository extends Repository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    Book findByNameAndWriterAllIgnoringCase(String name, String writer);

}
