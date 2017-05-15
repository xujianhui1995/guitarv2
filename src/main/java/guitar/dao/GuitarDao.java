package guitar.dao;

import java.util.List;

import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

public interface GuitarDao {
	List<Guitar> Search(Guitar searchGuitar);	

}
