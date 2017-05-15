package guitar.dao;

import java.util.List;

import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

public interface Inventory {
	List<Guitar> Search(Guitar searchGuitar);	

}
