package com.keystone.demo.Repository;


import com.keystone.demo.Entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion,Long> {
}
