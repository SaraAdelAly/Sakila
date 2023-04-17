package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.LanguageDao;
import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.entities.Film;
import gov.iti.jets.sakila.entities.Language;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;

public class LanguageMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    LanguageDao languageDao = new LanguageDao();
    public LanguageDto add(LanguageDto languageDto){
        Language language = modelMapper.map(languageDto, Language.class);
        return modelMapper.map(languageDao.addLanguage(language), LanguageDto.class);

    }
    public LanguageDto findLanguageById(int languageId){
       return modelMapper.map(languageDao.findLanguageById(languageId), LanguageDto.class);
    }



}
