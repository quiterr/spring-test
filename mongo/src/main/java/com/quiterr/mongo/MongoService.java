package com.quiterr.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by Huangchen on 2017/5/17.
 */
@Component
public class MongoService {
    private final MongoDbFactory mongo;

    @Autowired
    public MongoService(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    public void createUser(String name, String pass) {
        DB db = mongo.getDb();
        BasicDBObject basicDBObject = new BasicDBObject("createUser",name)
                .append("pwd",pass)
                .append("roles", Collections.singletonList(new BasicDBObject("role", "dbOwner").append("db", "stat")));
        db.command(basicDBObject);
    }
}
