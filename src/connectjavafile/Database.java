/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectjavafile;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lokesh
 */
public class Database {
    private Connection connection;                                             // The database connection object.
    private Statement statement;  
    
    // the database statement object, used to execute SQL commands.
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public Connection getConection(){
        return connection;
    }

    public Database (String username, String password ) {               // the constructor for the database manager.
        
        if (connection == null){
             String url = "jdbc:mysql://localhost:3306/" + "ezvz";       // our database--username is your O'Reilly login username and is passed in.
        try {
            Class.forName ("com.mysql.jdbc.Driver");                           // get the driver for this database.
            System.out.println("Driver is set; ready to go!");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC/ODBC driver.");
            return;                                                            // cannot even find the driver--return to caller since cannot do anything.
        }

        try {                                                                     // Establish the database connection, create a statement for execution of SQL commands.
            connection = (Connection) DriverManager.getConnection (url, username, password );  // username and password are passed into this Constructor.
            statement  = (Statement) connection.createStatement();                            // statement used to do things in the database (e.g., create the PhoneBook table).
        }catch (SQLException exception ) {
            System.out.println ("\n*** SQLException caught ***\n");
            while (exception != null) 
            {                                                                     // grab the exception caught to tell us the problem.
                System.out.println ("SQLState:   " + exception.getSQLState()  );
                System.out.println ("Message:    " + exception.getMessage()   );
                System.out.println ("Error code: " + exception.getErrorCode() );
                exception = exception.getNextException ();
                System.out.println ( "" );
            }
        }
        }
        
       
         // perhaps there is an exception that was not SQL related.
         // shows a trace of the exception error--like we see in the console.

    }
    
}
