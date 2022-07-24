package database;

import java.util.ArrayList;
import java.util.List;

public class CreateDatabase {
    public static String createDataBaseSql(){
        return  "DROP TABLE IF EXISTS components; " +
                        "CREATE TABLE components (" +
                        "component_id integer primary key," +
                        " component varchar(20)," +
                        " price integer);" +

                "DROP TABLE IF EXISTS confirm_order; " +
                        "CREATE TABLE confirm_order (" +
                        "order_id integer primary key," +
                        " videoCard varchar(30)," +
                        " processor varchar(30)," +
                        " ram varchar(30)," +
                        " confirm boolean);" +

                "DROP TABLE IF EXISTS done_order; " +
                        "CREATE TABLE done_order (" +
                        "order_id integer primary key," +
                        " videoCard varchar(30)," +
                        " processor varchar(30)," +
                        " ram varchar(30)," +
                        " price integer," +
                        " done boolean);" +

                "DROP TABLE IF EXISTS orders; " +
                        "CREATE TABLE orders (" +
                        "order_id integer primary key," +
                        " videoCard varchar(30)," +
                        " processor varchar(30)," +
                        " ram varchar(30)," +
                        " price integer," +
                        " feedback varchar(50));";


    }



    public static List<String> LocalData(){
        List<String> array = new ArrayList<>();
        array.add("insert into components values(1, 'gtx 960ti', 100);");
        array.add("insert into components values(2, 'core i5', 100);");
        array.add("insert into components values(3, 'ssd 200gb', 100);");

        array.add("insert into components values(4, 'gtx 1050ti', 200);");
        array.add("insert into components values(5, 'core i6', 200);");
        array.add("insert into components values(6, 'ssd 500gb', 200);");

        array.add("insert into components values(7, 'gtx 3060ti', 300);");
        array.add("insert into components values(8, 'core i7', 300);");
        array.add("insert into components values(9, 'ssd 1000gb', 300);");




        array.add("insert into confirm_order values(1, 'gtx 960ti', 'core i5', 'ssd 200gb', true);");


        array.add("insert into done_order values(1, 'gtx 960ti', 'core i5', 'ssd 200gb', 0, true);");


        array.add("insert into orders values(1, 'gtx 960ti', 'core i5', 'ssd 200gb', 0, 'Client feedback-1');");


        return array;
    }
}
