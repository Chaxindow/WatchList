package com.spring_demo.watch_list.dao;

import com.spring_demo.watch_list.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDAO extends JpaRepository<Content,Integer> {
}
