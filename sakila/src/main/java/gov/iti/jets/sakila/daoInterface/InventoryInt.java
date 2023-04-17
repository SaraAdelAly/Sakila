package gov.iti.jets.sakila.daoInterface;

import gov.iti.jets.sakila.entities.Inventory;

import java.util.List;

public interface InventoryInt {


    List<Inventory> getInventoriesByFilmId(int filmId);
    List<Inventory> getInventoriesByStoreId(int storeId);
    Long groupFilmNumInSameStore (int storeId, int filmId);
    Boolean checkFilmInStore (int filmId, int storeId);
}