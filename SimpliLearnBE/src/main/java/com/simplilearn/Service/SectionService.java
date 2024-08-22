package com.simplilearn.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.Entity.Section;
import com.simplilearn.repository.SectionRepository;

@Service
public class SectionService {
	
	@Autowired
	private SectionRepository sectionRepo;
	
	public Section addSection(Section section) {
		return sectionRepo.save(section);
	}
	
	public Collection<Section> getAllSection(){
		return sectionRepo.findAll();
	}
	
	public Section getSingleSection(Integer id) {
		Section section = null;
		Optional<Section> oneSection = sectionRepo.findById(id);
		if(oneSection.isPresent()) {
			section = oneSection.get();
		}
		return section;
	}
	
	public String deleteSection(Integer id) {
		sectionRepo.deleteById(id);
		return "Section Deleted successfuly! ";
	}
}
