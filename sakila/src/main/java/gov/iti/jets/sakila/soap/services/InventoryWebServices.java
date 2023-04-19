package gov.iti.jets.sakila.soap.services;

import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.persistence.dao.InventoryDao;
import gov.iti.jets.sakila.persistence.entities.Inventory;
import gov.iti.jets.sakila.services.InventoryServices;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
@WebService
public class InventoryWebServices {
    InventoryServices inventoryServices = new InventoryServices(new ModelMapper(), new InventoryDao());

    @WebMethod(operationName = "inventoryByFilm")
    public List<InventoryDto> getInventoriesByFilmId(@WebParam(name = "filmId")int filmId) {
       return inventoryServices.getInventoriesByFilmId(filmId);
    }
    @WebMethod(operationName = "inventoriesNumberByFilm&Store")
    public Long groupFilmNumInSameStore(@WebParam(name = "storeId")int storeId, @WebParam(name = "filmId")int filmId) {
        return inventoryServices.groupFilmNumInSameStore(storeId, filmId);
    }
    @WebMethod(operationName = "filmExistingInStoreChecking")
    public Boolean checkFilmInStore(@WebParam(name = "filmId")int filmId, @WebParam(name = "storeId")int storeId) {
        return inventoryServices.checkFilmInStore(filmId,storeId);
    }
    @WebMethod(operationName = "inventoriesByStore")
    public List<InventoryDto> getInventoriesByStoreId(@WebParam(name = "storeId")int storeId) {
        return inventoryServices.getInventoriesByStoreId(storeId);
    }
}
