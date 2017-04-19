
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yousefn1
 */
public class clsDB {
        static final String SQLite_DRIVER = "org.sqlite.JDBC"; 
    static String CONSTRING = null;
    private static Connection conn = null;
 

    public static void main(String[] args) {
        if (connectToSQLite()){
            System.out.println("Connected");
            storeToSQLite("light,22.82,2017-04-04T12:21:45.269+03:00,1491297705||Rssi,229,2017-04-04T12:21:45.269+03:00,1491297705||humidity,19.39,2017-04-04T12:21:45.269+03:00,1491297705||temperature,25.90,2017-04-04T12:21:45.269+03:00,1491297705||pir,0,2017-04-04T12:20:42.893+03:00,1491297642||co2,400,2017-04-04T12:30:09.028+03:00,1491298209||");
            disconnectSQLite();
        }
    
    }
    public static void ConnectStore(String data) {
        if (connectToSQLite()) {
            System.out.println("Connected");
            storeToSQLite(data);
            disconnectSQLite();
        }
    }

    public static boolean connectToSQLite(){
        CONSTRING = "jdbc:sqlite:\\home\\yousefn1\\OtaniemiDB.db"; 
        try {
            Class.forName(SQLite_DRIVER);
            conn = DriverManager.getConnection(CONSTRING);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
            return false;
        } catch (SQLException ex) {
            System.out.println("Sql Exception");
            return false;
        } catch (Exception e) {
            System.out.println("Error Occured");
            return false;
        }
    }

    public static void disconnectSQLite() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Conntection not Open");
        }
    }

    public static void storeToSQLite(String data) {
        String line;
        try {
                if (connectToSQLite()) {
                    for (String retval : data.split(Pattern.quote("||"))) {
                        String[] strArry = retval.split(Pattern.quote(","));
                        if (strArry.length == 4) {
                            Statement stmt=null;
                            String sql = "INSERT INTO Sensor (sName, sValue, sTime, sTimestamp ) VALUES ('" + strArry[0] + "','" + strArry[1] + "','" + strArry[2] + "','" + strArry[3] + "')";                    
                            stmt = conn.createStatement();
                            stmt.execute(sql);
                            stmt.close();
                        }
                    }
                    disconnectSQLite();
                } 
        } catch (SQLException ex) {
            System.out.println("SQLExecption = " + ex.fillInStackTrace());
        }
    }
}
