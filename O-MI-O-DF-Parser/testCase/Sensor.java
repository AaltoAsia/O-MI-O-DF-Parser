/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhikm1
 */
public class Sensor {

    String name;
    String value;
    String unixtime;
    String timestamp;
    String type;
    
    Sensor(String lname, String lvalue, String lunixtime,String ltimestamp) {
        name = lname;
        value = lvalue;
        unixtime = lunixtime;
        timestamp=ltimestamp;
    }

    public void setNmae(String lName) {
        name = lName;
    }

    public void setValue(String lvalue) {
        value = lvalue;
    }

    public void setunixTime(String lunixtime) {
        unixtime = lunixtime;
    }

    public void setTimestamp(String ltimestamp) {
        timestamp = ltimestamp;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getunixTime() {
        return unixtime;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
