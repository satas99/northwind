package com.turkcell.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.northwind.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
