package guitar.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitar.common.SQLiteJDBC;
import guitar.dao.GuitarDao;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

public class GuitarDaoimpl implements GuitarDao{
	private List<Guitar> guitars;
	private String sql;
	private PreparedStatement pstmt;
	public GuitarDaoimpl() {
		guitars=new LinkedList<Guitar>();
	}
	public List<Guitar> getGuitarLinkedList(){
		sql="select * from guitar;"; 
			try {
				pstmt =SQLiteJDBC.getConnection().prepareStatement(sql);      			
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					String serialNumber = rs.getString("serialNumber");
			        Double price = rs.getDouble("price");
			        String builder = rs.getString("builder");
			        String model = rs.getString("model");
			        String type = rs.getString("type");
			        int numStrings=rs.getInt("numStrings");
			        String backWood = rs.getString("backWood");
			        String topWood = rs.getString("topWood");
			        Guitar guitar=new Guitar(serialNumber,price,new GuitarSpec(builder,model,type,numStrings,backWood,topWood));
			        guitars.add(guitar);
				}
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return guitars;
		
	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		guitars=getGuitarLinkedList();
		List<Guitar> matchingGuitars = new LinkedList<Guitar>();
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchGuitar.getSpec()))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  
	}

}
