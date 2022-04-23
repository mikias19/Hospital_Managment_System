package hospitalmangment;
import  java.sql.*;
public class connectionprovider
   {
      public static Connection getcon()
      {
    	  try
          {
            
              
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","mikias_kebede_1991");
              
              return con;
          }
          catch(Exception e) 
                  {
                      return null;
                  }
      }
   }
