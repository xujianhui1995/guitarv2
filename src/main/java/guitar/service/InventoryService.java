package guitar.service;

import java.util.List;

import guitar.dao.Inventory;
import guitar.dao.impl.InventoryDaoimpl;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import guitar.service.impl.InventoryServiceimpl;

public interface InventoryService {

	List<Guitar> Search(Guitar searchGuitar);	

}
