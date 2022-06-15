package com.directors.page.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.directors.page.domain.Directors;
 
public interface DirectorsRepository extends JpaRepository<Directors, Long> {
 
}