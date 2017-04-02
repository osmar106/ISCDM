/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 *
 * @author Osmar
 */
public class video {
   private static String url = "jdbc:derby://localhost:1527/DBUsuarios";
   private static String user1 = "isdcm";
   private static String password1 = "1234";
   
   public static void insert (String[] args){
       try{
           System.out.println("Argument: " + Arrays.toString(args));
           
           String sqlStatement = MessageFormat.format("INSERT INTO VIDEOS VALUES(''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'',''{6}'',''{7}'')", 
                                                args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
           
           
           System.out.println("SQL statement: " + sqlStatement);
           
           Connection conn = DriverManager.getConnection(url,user1,password1);
           Statement st = conn.createStatement();
           st.executeUpdate(sqlStatement);
           
           conn.close();
       } catch (Exception e){
           System.err.println("Error: " + e.getMessage());
       }
   }
}
