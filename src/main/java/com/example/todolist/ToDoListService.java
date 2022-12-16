package com.example.todolist;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class ToDoListService {

    private static List<String> items = new LinkedList<>();

    public void addItem(String item){
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "");
        String url = "jdbc:mysql://localhost:3306/todolist";
        try(
                Connection conn = DriverManager.getConnection(url, props);
                Statement statement = conn.createStatement()){

            String query = "INSERT INTO item(description) values ('"+item+"')";

            statement.execute(query);

        }catch(SQLException e){
            System.out.println("Erro ao conectar no banco de dados."+e);
        }
    }

    public List<Item> getItems(){

        List<Item> items = new ArrayList<>();

        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "");
        String url = "jdbc:mysql://localhost:3306/todolist";

        try(
                Connection conn = DriverManager.getConnection(url, props);
                Statement statement = conn.createStatement()){

            String query = "SELECT * FROM item";
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                Long id = rs.getLong("id");
                String description = rs.getString("description");
                Item item = new Item(id, description);
                items.add(item);
            }

        }catch(SQLException e){
            System.out.println("Erro ao conectar no banco de dados."+e);
        }
        return items;
    }
}
