package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.Entity.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {

}
