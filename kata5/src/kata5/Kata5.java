package kata5;

import java.sql.*;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;


public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:data/PEOPLE.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT email FROM PEOPLE WHERE city='New York'");
    
        List<Mail> mailList = PeopleReader.read(resultSet);
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM...", mailHistogram);
        histogramDisplay.execute();
        statement.close();
    }

}
