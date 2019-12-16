package com.spring.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.webservices.restfulwebservices.bean.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer> {

}
