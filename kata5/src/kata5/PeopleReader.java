
package kata5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;



public class PeopleReader {
    
    public static List<Mail> read (ResultSet resultSet) throws SQLException {
        
        List<Mail> list = new ArrayList<>();
        
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(new Mail(email));
        }
        
        return list;
        
    }

}
