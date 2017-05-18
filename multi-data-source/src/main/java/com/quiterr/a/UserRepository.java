package com.quiterr.a;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Huangchen on 2017/5/18.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
