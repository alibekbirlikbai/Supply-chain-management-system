package database;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class HelloService {
    @EJB
    private Repository download;

    public List<String> getHello() throws SQLException, ClassNotFoundException{
        return download.getAllDemoName();
    }
}
