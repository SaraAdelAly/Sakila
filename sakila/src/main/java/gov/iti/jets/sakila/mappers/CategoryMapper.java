package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.CategoryDao;
import gov.iti.jets.sakila.dto.CategoryDto;
import gov.iti.jets.sakila.entities.Category;
import org.modelmapper.ModelMapper;

public class CategoryMapper {
    private ModelMapper modelMapper = new ModelMapper();
    CategoryDao categoryDao = new CategoryDao();

    public CategoryDto getFilmCategory (String title){
        Category category = categoryDao.getFilmCategory(title);
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto addCategory (CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return  modelMapper.map(categoryDao.addCategory(category), CategoryDto.class);

    }



}
