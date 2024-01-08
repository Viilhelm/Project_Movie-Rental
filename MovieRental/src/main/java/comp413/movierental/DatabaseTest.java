package comp413.movierental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String QUERY = "SELECT * FROM MOVIE";

    public static void main(String[] args) {
        System.out.println("DatabaseTest started");

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
    // Create a statement that produces a scrollable result set
    try (PreparedStatement statement = connection.prepareStatement(QUERY, 
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet resultSet = statement.executeQuery()) {

            

            // Iterate through the result set and print each movie's details
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("TITLE");
                int movieYear = resultSet.getInt("MOVIEYEAR");
                String genre = resultSet.getString("GENRE");
                String leadingActor = resultSet.getString("LEADINGACTOR");
                String studio = resultSet.getString("STUDIO");
                String director = resultSet.getString("DIRECTOR");
                double length = resultSet.getDouble("LENGTH");
                double rentalPrice = resultSet.getDouble("RENTALPRICE");
                double costProduction = resultSet.getDouble("COSTPRODUCTION");
                double estimatedBoxOfficeRevenue = resultSet.getDouble("ESTIMATEDBOXOFFICEREVENUE");

                // Print all retrieved fields
                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Year: " + movieYear);
                System.out.println("Genre: " + genre);
                System.out.println("Leading Actor: " + leadingActor);
                System.out.println("Studio: " + studio);
                System.out.println("Director: " + director);
                System.out.println("Length: " + length);
                System.out.println("Rental Price: " + rentalPrice);
                System.out.println("Cost Production: " + costProduction);
                System.out.println("Estimated Box Office Revenue: " + estimatedBoxOfficeRevenue);
                System.out.println("--------------------------------------------------");
            }
    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("DatabaseTest finished");
    }
}
