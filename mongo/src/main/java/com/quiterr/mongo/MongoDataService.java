package com.quiterr.mongo;

import com.quiterr.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Huangchen on 2017/5/17.
 */
@Component
public class MongoDataService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoDataService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void InsertBook(Book book){
        mongoTemplate.insert(book,"book");
    }

}
