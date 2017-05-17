package com.quiterr;

import com.quiterr.model.Book;
import com.quiterr.mongo.BookRepository;
import com.quiterr.mongo.MongoDataService;
import com.quiterr.mongo.MongoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


/**
 * Created by huangchen on 2016/5/19.
 */

@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    MongoService mongoService;

    @Autowired
    MongoDataService mongoDataService;

    @Autowired
    BookRepository bookRepository;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyStartupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        //test1
//        mongoService.createUser("test","test");

        //test2
//        Book book = new Book();
//        book.setId(2L);
//        book.setName("西游记");
//        book.setWriter("吴承恩");
//        mongoDataService.InsertBook(book);

        //test3
        PageRequest pageRequest = new PageRequest(0,20);
        Page<Book> books = bookRepository.findAll(pageRequest);
        for (Book book:books.getContent()) {
            logger.info(book.toString());
        }

    }
}
