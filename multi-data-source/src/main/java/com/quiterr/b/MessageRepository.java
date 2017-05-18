package com.quiterr.b;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Huangchen on 2017/5/18.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
