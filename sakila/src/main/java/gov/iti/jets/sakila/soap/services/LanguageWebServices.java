package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.persistance.dao.LanguageDao;
import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.persistance.entities.Language;
import gov.iti.jets.sakila.services.LanguageServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

@WebService
public class LanguageWebServices {
    LanguageServices languageServices = new LanguageServices(new ModelMapper(), new LanguageDao());

    @WebMethod(operationName = "addNewLanguage")
    public LanguageDto addLanguage(@WebParam(name = "language")LanguageDto languageDto){
        return languageServices.addLanguage(languageDto);

    }

    @WebMethod(operationName = "languageById")
    public LanguageDto findLanguageById(@WebParam(name = "languageId")int languageId){
        return languageServices.findLanguageById(languageId);
    }
}
