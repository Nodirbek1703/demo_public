package com.example.demo.repository;

import com.example.demo.entity.Details;
import com.example.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {

}
