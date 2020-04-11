package com.epam;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/message?useUnicode=true&serverTimezone=UTC";

    public static ArrayList<Plane> select() {
        ArrayList<Plane> planes = new ArrayList<Plane>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT  * FROM plane");
                while (resultSet.next()) {
                    int idPlanes = resultSet.getInt(1);
                    int liftingWeight = resultSet.getInt(2);
                    int maxDistance = resultSet.getInt(3);
                    int consumption = resultSet.getInt(4);
                    int numberPlaces = resultSet.getInt(5);
                    Plane plane = new Plane(idPlanes, liftingWeight, maxDistance, consumption, numberPlaces);
                    planes.add(plane);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return planes;
    }

    public static Plane selectOne(int idPlanes) {

        Plane plane = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

                String sql = "SELECT * FROM plane WHERE idplanes=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, idPlanes);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int planeId = resultSet.getInt(1);
                        int liftWeight = resultSet.getInt(2);
                        int maxDist = resultSet.getInt(3);
                        int consumpPlane = resultSet.getInt(4);
                        int numbPlaces = resultSet.getInt(5);
                        plane = new Plane(planeId, liftWeight, maxDist,consumpPlane,numbPlaces);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return plane;
    }

    public static int insert(Plane plane) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "INSERT INTO plane (idplanes, lifting_weight,max_distance,consumption,number_places) Values (?,?,?,?,?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, plane.getIdPlanes());
                    preparedStatement.setInt(2, plane.getLiftingWeight());
                    preparedStatement.setInt(2, plane.getMaxDistance());
                    preparedStatement.setInt(2, plane.getConsumption());
                    preparedStatement.setInt(2, plane.getNumberPlaces());
                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Plane plane) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

                String sql = "UPDATE plane SET lifting_weight = ?, max_distance = ?, consumption = ?, number_places = ? WHERE idplanes = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, plane.getIdPlanes());
                    preparedStatement.setInt(2, plane.getLiftingWeight());
                    preparedStatement.setInt(3, plane.getMaxDistance());
                    preparedStatement.setInt(3, plane.getConsumption());
                    preparedStatement.setInt(3, plane.getNumberPlaces());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int idPlanes) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){

                String sql = "DELETE FROM plane WHERE idplanes = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, idPlanes);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
