package database;


import model.Component;
import model.ConfirmOrder;
import model.DoneOrder;
import model.Orders;

import javax.ejb.Stateful;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class Repository {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Java_final";
    private static final String USER = "postgres";
    private static final String PASS = "123";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public Repository() throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            e.printStackTrace();
            return;
        }
        System.out.println("Connection to DataBase...");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Success!");
        statement = connection.createStatement();
        //PreparedStatement preparedStatement = connection.prepareStatement();
        //CallableStatement callableStatement = connection.prepareCall();
        statement.executeUpdate(CreateDatabase.createDataBaseSql());

        connection.setAutoCommit(false);
        Statement finalStatement = statement;
        CreateDatabase.LocalData().forEach(sql ->{
            try {
                finalStatement.executeUpdate(sql);
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
        });
        connection.commit();
    }

    //Default sql method
    public List<String> getAllDemoName() throws  SQLException{
        List<String> names = new ArrayList<>();
        String sql = "SELECT * FROM demo";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            System.out.println("ID " + id);
            String name = resultSet.getString("Name");

            String desc = resultSet.getString("Hint");
            names.add(String.valueOf(id));
            names.add(name);
            names.add(desc);
        }
        return names;
    }



    //Dealer(Component) - CRUD
    public List<Component> getAllFromDealer() throws SQLException {
        String sql = "select * from components";
        ResultSet rs = statement.executeQuery(sql);
        List<Component> dealerList = new ArrayList<>();
        while (rs.next()) {
            int component_id = rs.getInt("component_id");
            String component = rs.getString("component");
            int price = rs.getInt("price");
            dealerList.add(new Component(component_id, component, price));
        }
        return dealerList;
    }

    public void deleteAllFromDealer() throws SQLException {
        String sql = "delete from components;";
        statement.executeUpdate(sql);
    }

    public void insertDealer(Component component) throws SQLException {
        String sql = "insert into components values('" + component.getComponent_id() + "','" + component.getComponent() + "','" + component.getPrice() + "');";
        statement.executeUpdate(sql);
    }

    public void deleteDealer(int id) throws SQLException {
        String sql = "delete from components where (component_id='" + id + "');";
        statement.executeUpdate(sql);
    }

    public void updateDealer(Component component) throws SQLException {
        String sql = "update components set component='" + component.getComponent() + "', price='" + component.getPrice() + "' where (component_id='" + component.getComponent_id() + "');";
        statement.executeUpdate(sql);
    }

    public List<Component> getByIdFromDealer(int id) throws SQLException {
        String sql = "select * from components where (component_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        List<Component> dealerList = new ArrayList<>();
        while (rs.next()) {
            int component_id = rs.getInt("component_id");
            String component = rs.getString("component");
            int price = rs.getInt("price");
            dealerList.add(new Component(component_id, component, price));
        }
        return dealerList;
    }





    //ConfirmOrder - CRUD
    public List<ConfirmOrder> getAllFromConfirmOrder() throws SQLException {
        String sql = "select * from confirm_order";
        ResultSet rs = statement.executeQuery(sql);
        List<ConfirmOrder> confirmOrderList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            Boolean confirm = rs.getBoolean("confirm");
            confirmOrderList.add(new ConfirmOrder(order_id, videoCard, processor, ram, confirm));
        }
        return confirmOrderList;
    }

    public void deleteAllFromConfirmOrder() throws SQLException {
        String sql = "delete from confirm_order;";
        statement.executeUpdate(sql);
    }

    public void insertConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        String sql = "insert into confirm_order values('" + confirmOrder.getOrder_id() + "','" + confirmOrder.getVideoCard() + "','" + confirmOrder.getProcessor() + "','" + confirmOrder.getRam()  + "','" + confirmOrder.getConfirm() + "');";
        statement.executeUpdate(sql);
    }

    public void deleteConfirmOrder(int id) throws SQLException {
        String sql = "delete from confirm_order where (order_id='" + id + "');";
        statement.executeUpdate(sql);
    }

    public void updateConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        String sql = "update confirm_order set videoCard='" + confirmOrder.getVideoCard() + "', processor='" + confirmOrder.getProcessor() + "', ram='" + confirmOrder.getRam() + "', confirm='" + confirmOrder.getConfirm() + "' where (order_id='" + confirmOrder.getOrder_id() + "');";
        statement.executeUpdate(sql);
    }

    public List<ConfirmOrder> getByIdFromConfirmOrder(int id) throws SQLException {
        String sql = "select * from confirm_order where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        List<ConfirmOrder> confirmOrderList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            Boolean confirm = rs.getBoolean("confirm");
            confirmOrderList.add(new ConfirmOrder(order_id, videoCard, processor, ram, confirm));
        }
        return confirmOrderList;
    }




    //DoneOrder - CRUD
    public List<DoneOrder> getAllFromDoneOrder() throws SQLException {
        String sql = "select * from done_order";
        ResultSet rs = statement.executeQuery(sql);
        List<DoneOrder> doneOrderList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            int price = rs.getInt("price");
            Boolean done = rs.getBoolean("done");
            doneOrderList.add(new DoneOrder(order_id, videoCard, processor, ram, price, done));
        }
        return doneOrderList;
    }

    public void deleteAllFromDoneOrder() throws SQLException {
        String sql = "delete from done_order;";
        statement.executeUpdate(sql);
    }

    public void insertDoneOrder(DoneOrder doneOrder) throws SQLException {
        String sql = "insert into done_order values('" + doneOrder.getOrder_id() + "','" + doneOrder.getVideoCard() + "','" + doneOrder.getProcessor() + "','" + doneOrder.getRam() + "','" + doneOrder.getPrice() + "','" + doneOrder.getDone() + "');";
        statement.executeUpdate(sql);
    }

    public void deleteDoneOrder(int id) throws SQLException {
        String sql = "delete from done_order where (order_id='" + id + "');";
        statement.executeUpdate(sql);
    }

    public void updateDoneOrder(DoneOrder doneOrder) throws SQLException {
        String sql = "update done_order set videoCard='" + doneOrder.getVideoCard() + "', processor='" + doneOrder.getProcessor() + "', ram='" + doneOrder.getRam() + "', price='" + doneOrder.getPrice() + "', done='" + doneOrder.getDone() + "' where (order_id='" + doneOrder.getOrder_id() + "');";
        statement.executeUpdate(sql);
    }

    public List<DoneOrder> getByIdFromDoneOrder(int id) throws SQLException {
        String sql = "select * from done_order where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        List<DoneOrder> doneOrderList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            int price = rs.getInt("price");
            Boolean done = rs.getBoolean("done");
            doneOrderList.add(new DoneOrder(order_id, videoCard, processor, ram, price, done));
        }
        return doneOrderList;
    }




    //Orders - CRUD
    public List<Orders> getAllFromOrders() throws SQLException {
        String sql = "select * from orders";
        ResultSet rs = statement.executeQuery(sql);
        List<Orders> ordersList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            int price = rs.getInt("price");
            String feedback = rs.getString("feedback");
            ordersList.add(new Orders(order_id, videoCard, processor, ram, price, feedback));
        }
        return ordersList;
    }

    public void deleteAllFromOrders() throws SQLException {
        String sql = "delete from orders;";
        statement.executeUpdate(sql);
    }

    public void insertOrders(Orders orders) throws SQLException {
        String sql = "insert into orders values('" + orders.getOrder_id() + "','" + orders.getVideoCard() + "','" + orders.getProcessor() + "','" + orders.getRam() + "','" + orders.getPrice() + "','" + orders.getFeedback() + "');";
        statement.executeUpdate(sql);
    }

    public void deleteOrders(int id) throws SQLException {
        String sql = "delete from orders where (order_id='" + id + "');";
        statement.executeUpdate(sql);
    }

    public void updateOrders(Orders orders) throws SQLException {
        String sql = "update orders set videoCard='" + orders.getVideoCard() + "', processor='" + orders.getProcessor() + "', ram='" + orders.getRam() + "', price='" + orders.getPrice() + "', feedback='" + orders.getFeedback() + "' where (order_id='" + orders.getOrder_id() + "');";
        statement.executeUpdate(sql);
    }

    public List<Orders> getByIdFromOrders(int id) throws SQLException {
        String sql = "select * from orders where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        List<Orders> ordersList = new ArrayList<>();
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            int price = rs.getInt("price");
            String feedback = rs.getString("feedback");
            ordersList.add(new Orders(order_id, videoCard, processor, ram, price, feedback));
        }
        return ordersList;
    }




    //******************************************  LOGIC_of_Project  ********************************************
    public void insertClient_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        String sql = "insert into confirm_order values('" + confirmOrder.getOrder_id() + "','" + confirmOrder.getVideoCard() + "','" + confirmOrder.getProcessor() + "','" + confirmOrder.getRam() + "', false);";
        statement.executeUpdate(sql);
    }
    public void updateAdmin_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        String sql_update_confirm_status = "update confirm_order set confirm='" + confirmOrder.getConfirm() + "' where (order_id='" + confirmOrder.getOrder_id() + "');";
        statement.executeUpdate(sql_update_confirm_status);
    }
    public String getByIdAdmin_ConfirmOrder(int id) throws SQLException {
        String check = "NOT confirmed";
        int order_id_new = 0;
        String videoCard_new = "";
        String processor_new = "";
        String ram_new = "";


        String sql = "select * from confirm_order where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            Boolean confirm = rs.getBoolean("confirm");

            if (confirm) {
                check = "confirmed";
                order_id_new = order_id;
                videoCard_new = videoCard;
                processor_new = processor;
                ram_new = ram;
            }
        }
        if (check.equals("confirmed")) {
            String sql_delete_confirmed = "delete from confirm_order where (order_id='" + order_id_new + "');";
            statement.executeUpdate(sql_delete_confirmed);
            String sql_insert_done = "insert into done_order values('" + order_id_new + "','" + videoCard_new + "','" + processor_new + "','" + ram_new + "', 0, false);";
            statement.executeUpdate(sql_insert_done);
        }
        return check;
    }




    //Проверка
    public String getByIdAdmin_CheckComponent(int id) throws SQLException {
        String available_component = "NO";
        int price_sum = 0;
        String videoCard_new = "";
        String processor_new = "";
        String ram_new = "";
        Boolean done_status;


        String sql = "select * from done_order where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            //int price = rs.getInt("price");
            Boolean done = rs.getBoolean("done");


                videoCard_new = videoCard;
                processor_new = processor;
                ram_new = ram;

        }
            String sql2 = "select * from components";
            ResultSet rs2 = statement.executeQuery(sql2);
            List<Component> dealerList = new ArrayList<>();
            List<Integer> availableComponentList = new ArrayList<>();
            while (rs2.next()) {
                int component_id = rs2.getInt("component_id");
                String component = rs2.getString("component");
                int price = rs2.getInt("price");
                dealerList.add(new Component(component_id, component, price));

                int count = 0;
                for (int i = 0; i < dealerList.size(); i++ ) {
                    if (videoCard_new.equals(dealerList.get(i).getComponent())) {
                        count++;
                        price_sum += dealerList.get(i).getPrice();

                        availableComponentList.add(i);
                    } else
                    if (processor_new.equals(dealerList.get(i).getComponent())) {
                        count++;
                        price_sum += dealerList.get(i).getPrice();

                        availableComponentList.add(i);
                    } else
                    if (ram_new.equals(dealerList.get(i).getComponent())) {
                        count++;
                        price_sum += dealerList.get(i).getPrice();

                        availableComponentList.add(i);
                    }
                }

                if (count == 3) {
                    available_component = "YES";
                }
            }



            if (available_component.equals("YES")) {
                //Delete available components from Dealer table(components)
                for (int component_id: availableComponentList) {
                    String sql_delete_available_component = "delete from components where (component_id='" + component_id + "');";
                    statement.executeUpdate(sql_delete_available_component);
                }

//                String sql_delete_available_component_1 = "delete from components where (component_id='" + availableComponentList.get(0) + "');";
//                statement.executeUpdate(sql_delete_available_component_1);
//
//                String sql_delete_available_component_2 = "delete from components where (component_id='" + availableComponentList.get(1) + "');";
//                statement.executeUpdate(sql_delete_available_component_2);
//
//                String sql_delete_available_component_3 = "delete from components where (component_id='" + availableComponentList.get(3) + "');";
//                statement.executeUpdate(sql_delete_available_component_3);




                price_sum = price_sum / 8;
                String sql_update_price = "update done_order set price='" + price_sum + "' where (order_id='" + id + "');";
                statement.executeUpdate(sql_update_price);

                done_status = true;
                String sql_update_done_status = "update done_order set done='" + done_status + "' where (order_id='" + id + "');";
                statement.executeUpdate(sql_update_done_status);

                String sql_insert_final_order = "insert into orders values('" + id + "','" + videoCard_new + "','" + processor_new + "','" + ram_new + "', '" + price_sum + "', '');";
                statement.executeUpdate(sql_insert_final_order);
            }
        return available_component;
    }



    //Комментарий Клиента
    public void updateClientFeedback_Orders(Orders orders) throws SQLException {
        String sql = "update orders set feedback='" + orders.getFeedback() + "' where (order_id='" + orders.getOrder_id() + "');";
        statement.executeUpdate(sql);
    }








    //Дополнительные методы (+2)
    public void updateAdmin_DoneOrder(DoneOrder doneOrder) throws SQLException {
        String sql = "update done_order set done='" + doneOrder.getDone() + "' where (order_id='" + doneOrder.getOrder_id() + "');";
        statement.executeUpdate(sql);
    }


    public String getByIdAdmin_CheckDoneOrder(int id) throws SQLException {
        String check = "NOT done";

        int order_id_new = 0;
        String videoCard_new = "";
        String processor_new = "";
        String ram_new = "";
        int price_new = 0;


        String sql = "select * from done_order where (order_id='" + id + "');";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int order_id = rs.getInt("order_id");
            String videoCard = rs.getString("videoCard");
            String processor = rs.getString("processor");
            String ram = rs.getString("ram");
            int price = rs.getInt("price");
            Boolean done = rs.getBoolean("done");

            if (done) {
                check = "done";
                order_id_new = order_id;
                videoCard_new = videoCard;
                processor_new = processor;
                ram_new = ram;
                price_new = price;
            }
        }
        if (check.equals("done")) {
            String sql_insert_done = "insert into orders values('" + order_id_new + "','" + videoCard_new + "','" + processor_new + "','" + ram_new + "', '" + price_new + "');";
            statement.executeUpdate(sql_insert_done);
        }
        return check;
    }




}