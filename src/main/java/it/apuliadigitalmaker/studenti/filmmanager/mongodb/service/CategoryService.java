package it.apuliadigitalmaker.studenti.filmmanager.mongodb.service;


import java.util.List;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.requestDto.CategoryRequestDto;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.responseDto.CategoryResponseDto;

public interface CategoryService {
	
	public List<CategoryResponseDto> findCategories(String name) ;
	
	public CategoryResponseDto findCategoryById(Long id);
	
	public CategoryResponseDto createCategory(CategoryRequestDto categoryRequest);
	
	public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequest, Long categoryId);
	
	public boolean deleteCategory(Long id);

}
