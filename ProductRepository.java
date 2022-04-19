package com.example.new_proj.Repo;

import com.example.new_proj.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
