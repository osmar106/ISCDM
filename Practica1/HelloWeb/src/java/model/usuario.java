/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Arrays;


/**
 *
 * @author Osmar 
 */
public class usuario {
   private static String url = "jdbc:derby://localhost:1527/DBUsuarios";
   private static String user1 = "isdcm";
   private static String password1 = "1234";
   
   public static void insert (String[] args){
       try{
           System.out.println("Argument: " + Arrays.toString(args));
           
           String sqlStatement = MessageFormat.format("INSERT INTO USUARIOS VALUES(''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'')", 
                                                args[0], args[1], args[2], args[3], args[4], args[5]);
           
           
           System.out.println("SQL statement: " + sqlStatement);
           
           Connection conn = DriverManager.getConnection(url,user1,password1);
           Statement st = conn.createStatement();
           st.executeUpdate(sqlStatement);
           
           conn.close();
       } catch (Exception e){
           System.err.println("Error: " + e.getMessage());
       }
   }
   
   public static boolean checkIfUserExists (String user){
       boolean result = false;
       
       try{
           Connection conn = DriverManager.getConnection(url,user1,password1);
           Statement st = conn.createStatement();
           String sqlStatement = MessageFormat.format("SELECT * FROM ISDCM.USUARIOS WHERE USUARIO=''{0}''", user);
           System.out.println("SQL statement: " + sqlStatement);
           
           ResultSet rs = st.executeQuery(sqlStatement);
           
           //System.out.println("Result set: " + rs.getInt("total"));
           
            if(rs.next()){
                System.out.println("record found");
                conn.close();
                result = true;
            }
              
            else{
                System.out.println("record not found");
                conn.close();
                result = false;
            }
           
       } catch (Exception e){
           System.err.println("Error");
           System.err.println(e.getMessage());
       }
       
       return result;
   }
   
   public static boolean login (String user, String password){
       boolean result = false;
       
       try{

           Connection conn = DriverManager.getConnection(url,user1,password1);
           Statement st = conn.createStatement();
           String sqlStatement = MessageFormat.format("SELECT * FROM ISDCM.USUARIOS WHERE USUARIO=''{0}''", user);
           System.out.println("SQL statement: " + sqlStatement);
           
           ResultSet rs = st.executeQuery(sqlStatement);
           
           //System.out.println("Result set: " + rs.getInt("total"));
           
            if(rs.next()){
                String passwordgot = rs.getString("CONTRASEÑA");
                System.out.println(passwordgot);
                
                if(passwordgot.equals(password)){
                    result = true;
                }
                else{
                    result = false;
                }
                
                System.out.println("record found");
                conn.close();
             
            }
              
            else{
                System.out.println("record not found");
                conn.close();
                result = false;
            }
           
       } catch (Exception e){
           System.err.println("Error");
           System.err.println(e.getMessage());
       }
       
       return result;
   }

}


