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

        String sql = "SELECT c.idcancion, c.nombre_cancion, b.idbanda FROM cancion c, banda b\n" +
                "where c.idcancion IN (SELECT cancion_idcancion FROM reproduccion\n" +
                "GROUP BY cancion_idcancion  \n" +
                "having count(*) >2 \n" +
                "ORDER BY count(*) DESC) and c.banda=b.idbanda;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url,"root","root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)){

            while(resultSet.next()){
                Cancion cancion = new Cancion();
                cancion.setIdcancion(resultSet.getInt(1));
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
