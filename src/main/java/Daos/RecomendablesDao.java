package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendablesDao {
    public ArrayList<Cancion> lista(){
        ArrayList<Cancion> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM canciones ";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url,"root","root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)){

            while(resultSet.next()){
                Cancion cancion = new Cancion();
                cancion.setNombreCancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                lista.add(cancion);
            }

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return lista;
    }
}
