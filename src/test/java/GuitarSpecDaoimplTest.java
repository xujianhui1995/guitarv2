/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import guitar.common.SQLiteJDBC;
import guitar.dao.Inventory;
import guitar.dao.impl.InventoryDaoimpl;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GuitarSpecDaoimplTest {
	private String sql;
	private PreparedStatement pstmt;

      @Test
      public void getGuitarLinkedList(){
  			sql="select * from guitar;";  
  			List<Guitar> guitars=new LinkedList<Guitar>();
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
  			
  	    	System.out.println(guitars.get(0).getSerialNumber());

  	}
      @Test
      public void getGuitarLinkedList2(){
      	InventoryDaoimpl gsp=new InventoryDaoimpl();      	
      	System.out.println(gsp.getGuitarLinkedList().get(0).getSerialNumber());
      }
      @Test
      public void matches(){
    	
    	GuitarSpec gs=new GuitarSpec("1", "1", "1", 0, "1", "1");
    	GuitarSpec sh=new GuitarSpec("2", "1", "1", 0, "1", "1");

      	System.out.println(gs.matches(sh));
    	}
      @Test
      public void Search(){
      	Inventory gd=new InventoryDaoimpl(); 
		Guitar searchGuitar=new Guitar("11277", 1499.95,new GuitarSpec("Collings", "CJ", "acoustic", 12, "Indian Rosewood", "Sitka")); 
		gd.Search(searchGuitar);
      	System.out.println(gd.Search(searchGuitar).get(0).getSerialNumber());
      }
    
    	
}
