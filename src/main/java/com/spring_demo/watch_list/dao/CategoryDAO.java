package com.spring_demo.watch_list.dao;

import com.spring_demo.watch_list.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDAO  extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
