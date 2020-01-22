/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectjavafile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lokesh
 */
public class ConnectJavaFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Database databaseManager = new Database( "root", "" ); 
        Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        String query = " insert into view_data (current_user_id, saved_user_id, created_at, updated_at)"
        + " values (?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = null;
        try {
            preparedStmt = databaseManager.getConection().prepareStatement(query);
             preparedStmt.setString (1, "test9329432");
             preparedStmt.setString (2, "testsav32342");
            preparedStmt.setDate   (3, startDate);
            preparedStmt.setDate(4, startDate);
//             preparedStmt.setInt    (5, 5000);

      // execute the preparedstatement
      preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJavaFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query1 = "select * from view_data";
        try {
//            preparedStmt.execute(query1);
             ResultSet rs = preparedStmt.executeQuery(query1);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String current_user_id = rs.getString("current_user_id");
//         String first = rs.getString("first");
//         String last = rs.getString("last");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Current UserID: " + current_user_id+"\n");
//         System.out.print(", First: " + first);
//         System.out.println(", Last: " + last);
      }
      rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectJavaFile.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
