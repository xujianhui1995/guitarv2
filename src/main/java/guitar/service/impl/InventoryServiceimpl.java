package guitar.service.impl;

import java.util.List;

import guitar.dao.Inventory;
import guitar.dao.impl.InventoryDaoimpl;
import guitar.domain.Guitar;
import guitar.service.InventoryService;

public class InventoryServiceimpl implements InventoryService {
	private Inventory guitarDao;
	public void setGuitarDao(Inventory guitarDao) {
		this.guitarDao = guitarDao;
	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		Inventory GuitarDaoimpl=new InventoryDaoimpl();
		setGuitarDao(GuitarDaoimpl);
		return guitarDao.Search(searchGuitar);
	}

	
	

}
