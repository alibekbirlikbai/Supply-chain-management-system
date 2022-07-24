package service;
//
//import data.Component;
//import data.ConfirmOrder;
//import data.DoneOrder;
//import data.Orders;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//public interface ServiceInterface {
//    //Dealer(6) - CRUD + 2
//    public List<Component> getAllFromDealer() throws SQLException;
//    public String deleteAllFromDealer() throws SQLException;
//    public String insertDealer(Component component) throws SQLException;
//    public String deleteDealer(int id) throws SQLException;
//    public String updateDealer(Component component) throws SQLException;
//    public List<Component> getByIdFromDealer(int id) throws SQLException;
//
//    //ConfirmOrder(6) - CRUD + 2
//    public List<ConfirmOrder> getAllFromConfirmOrder() throws SQLException;
//    public String deleteAllFromConfirmOrder() throws SQLException;
//    public String insertConfirmOrder(ConfirmOrder confirmOrder) throws SQLException;
//    public String deleteConfirmOrder(int id) throws SQLException;
//    public String updateConfirmOrder(ConfirmOrder confirmOrder) throws SQLException;
//    public List<ConfirmOrder> getByIdFromConfirmOrder(int id) throws SQLException;
//
//    //DoneOrder(6) - CRUD + 2
//    public List<DoneOrder> getAllFromDoneOrder() throws SQLException;
//    public String deleteAllFromDoneOrder() throws SQLException;
//    public String insertDoneOrder(DoneOrder doneOrder) throws SQLException;
//    public String deleteDoneOrder(int id) throws SQLException;
//    public String updateDoneOrder(DoneOrder doneOrder) throws SQLException;
//    public List<DoneOrder> getByIdFromDoneOrder(int id) throws SQLException;
//
//    //Orders(6) - CRUD + 2
//    public List<Orders> getAllFromOrders() throws SQLException;
//    public String deleteAllFromOrders() throws SQLException;
//    public String insertOrders(Orders orders) throws SQLException;
//    public String deleteOrders(int id) throws SQLException;
//    public String updateOrders(Orders orders) throws SQLException;
//    public List<Orders> getByIdFromOrders(int id) throws SQLException;
//
//
//
//
//    //*******************************  LOGIC_of_Project  *************************************
//    public String insertClient_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException;
//    public String updateAdmin_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException;
//    public String getByIdAdmin_ConfirmOrder(int id) throws SQLException;
//
//    public String updateClientFeedback_DoneOrder(DoneOrder doneOrder) throws SQLException;
//    public String updateAdmin_DoneOrder(DoneOrder doneOrder) throws SQLException;
//    public String getByIdAdmin_DoneOrder(int id) throws SQLException;
//
//
//    //Проверка
//    public String getByIdAdmin_CheckComponent(int id) throws SQLException;
//}
