package program;

import Model.Client;
import Model.Lawyer;
import Model.Users;

import java.sql.*;
import java.util.ArrayList;

public class DBhelper {

    static public ArrayList<Users> read_Users(){
        ArrayList<Users> usersArrayList = new ArrayList<>();
        String sql = "SELECT ID,Username,Password,UserType FROM Users";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                usersArrayList.add(new Users(resultSet.getInt("ID"),resultSet.getString("Username"),resultSet.getString("Password"),resultSet.getString("UserType")));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return usersArrayList;
    }

    static public ArrayList<Lawyer> read_Lawyer(){
        ArrayList<Lawyer> lawyerArrayList = new ArrayList<>();
        String sql = "SELECT ID,Username,Password,Name,Email,Tel,Date FROM Lawyer";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                lawyerArrayList.add(new Lawyer(resultSet.getInt("ID"),resultSet.getString("Username"),resultSet.getString("Password"),resultSet.getString("Name"),
                        resultSet.getString("Email"),resultSet.getString("Tel"),resultSet.getString("Date")));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return lawyerArrayList;
    }

    static public ArrayList<Client> read_Client(){
        ArrayList<Client> clientArrayList = new ArrayList<>();
        String sql = "SELECT ID,Username,Password,Name,Email,Id_Card,Tel,Date FROM Client";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                clientArrayList.add(new Client(resultSet.getInt("ID"),resultSet.getString("Username"),resultSet.getString("Password"),resultSet.getString("Name"),
                        resultSet.getString("Email"),resultSet.getString("Id_Card"),resultSet.getString("Tel"),resultSet.getString("Date")));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return clientArrayList;
    }

    static public void write_Users(String username,String password, String userType){
        String sql = "INSERT INTO Users(Username,Password,UserType) VALUES(?,?,?)";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,userType);
            preparedStatement.executeUpdate();
            System.out.println("successW01");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static public void write_Lawyer(String username,String password, String name, String email, String tel, String date){
        String sql = "INSERT INTO Lawyer(Username,Password,Name,Email,Tel,Date) VALUES(?,?,?,?,?,?)";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,tel);
            preparedStatement.setString(6,date);
            preparedStatement.executeUpdate();
            System.out.println("successW02");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static public void write_Client(String username,String password, String name, String email,String id_card, String tel, String date){
        String sql = "INSERT INTO Client(Username,Password,Name,Email,Id_Card,Tel,Date) VALUES(?,?,?,?,?,?,?)";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,id_card);
            preparedStatement.setString(6,tel);
            preparedStatement.setString(7,date);
            preparedStatement.executeUpdate();
            System.out.println("successW03");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
