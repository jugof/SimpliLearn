package com.simplilearn.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.Entity.Section;
import com.simplilearn.Service.SectionService;

@CrossOrigin
@RestController
@RequestMapping
public class SectionController {

	@Autowired
	private SectionService sectionSer;
	
	@PostMapping("/addsection")
	public Section addSection( @RequestBody Section section) {
		return sectionSer.addSection(section);
	}
	
	@GetMapping("/sections")
	public Collection<Section> getAllSections() {
		return sectionSer.getAllSection();
	}
	
	@GetMapping("/section/{id}")
	public Section getSingleSection( @PathVariable Integer id) {
		return sectionSer.getSingleSection(id);
	}
	
	@DeleteMapping("/section/{id}")
	public String deleteSection( @PathVariable Integer id) {
		return sectionSer.deleteSection(id);
	}
}
