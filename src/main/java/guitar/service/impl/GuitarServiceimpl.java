package guitar.service.impl;

import java.util.List;

import guitar.dao.GuitarDao;
import guitar.dao.impl.GuitarDaoimpl;
import guitar.domain.Guitar;
import guitar.service.GuitarService;

public class GuitarServiceimpl implements GuitarService {
	private GuitarDao guitarDao;
	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		GuitarDao GuitarDaoimpl=new GuitarDaoimpl();
		setGuitarDao(GuitarDaoimpl);
		return guitarDao.Search(searchGuitar);
	}

	
	

}
