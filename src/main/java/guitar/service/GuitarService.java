package guitar.service;

import java.util.List;

import guitar.dao.GuitarDao;
import guitar.dao.impl.GuitarDaoimpl;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import guitar.service.impl.GuitarServiceimpl;

public interface GuitarService {

	List<Guitar> Search(Guitar searchGuitar);	

}
