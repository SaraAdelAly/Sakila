package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dao.InventoryDao;
import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.entities.Inventory;
import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class InventoryMapper {
    private ModelMapper modelMapper = new ModelMapper();
    InventoryDao inventoryDao = new InventoryDao();

    public List<InventoryDto> getInventoriesByFilmId(int filmId) {
       List<Inventory> inventories = inventoryDao.getInventoriesByFilmId(filmId);
       List<InventoryDto> inventoryDtos = new ArrayList<>();
       for(Inventory inventory : inventories){
           InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
           inventoryDtos.add(inventoryDto);
       }
       return inventoryDtos;
    }

    public List<InventoryDto> getInventoriesByStoreId(int storeId) {
        List<Inventory> inventories = inventoryDao.getInventoriesByStoreId(storeId);
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for(Inventory inventory : inventories){
            InventoryDto inventoryDto = modelMapper.map(inventory, InventoryDto.class);
            inventoryDtos.add(inventoryDto);
        }
        return inventoryDtos;
    }


}
