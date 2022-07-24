package service;

import model.Component;
import model.ConfirmOrder;
import model.DoneOrder;
import model.Orders;
import database.Repository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;


@Stateless
//@javax.enterprise.context.RequestScoped
public class ServiceImpl  {        //implements ServiceInterface
    @EJB
    private Repository repository;

    //Dealer(6) - CRUD + 2
    public List<Component> getAllFromDealer() throws SQLException {
        return repository.getAllFromDealer();
    }
    public String deleteAllFromDealer() throws SQLException {
        repository.deleteAllFromDealer();
        return "deleteAllFromDealer is successful";
    }
    public String insertDealer(Component component) throws SQLException {
        repository.insertDealer(component);
        return "insertDealer is successful";
    }
    public String deleteDealer(int id) throws SQLException {
        repository.deleteDealer(id);
        return "deleteDealer is successful";
    }
    public String updateDealer(Component component) throws SQLException {
        repository.updateDealer(component);
        return "updateDealer is successful";
    }
    public List<Component> getByIdFromDealer(int id) throws SQLException {
        return repository.getByIdFromDealer(id);
    }



    //ConfirmOrder(6) - CRUD + 2
    public List<ConfirmOrder> getAllFromConfirmOrder() throws SQLException {
        return repository.getAllFromConfirmOrder();
    }
    public String deleteAllFromConfirmOrder() throws SQLException {
        repository.deleteAllFromConfirmOrder();
        return "deleteAllFromConfirmOrder is successful";
    }
    public String insertConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        repository.insertConfirmOrder(confirmOrder);
        return "insertConfirmOrder is successful";
    }
    public String deleteConfirmOrder(int id) throws SQLException {
        repository.deleteConfirmOrder(id);
        return "deleteConfirmOrder is successful";
    }
    public String updateConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        repository.updateConfirmOrder(confirmOrder);
        return "updateConfirmOrder is successful";
    }
    public List<ConfirmOrder> getByIdFromConfirmOrder(int id) throws SQLException {
        return repository.getByIdFromConfirmOrder(id);
    }



    //DoneOrder(6) - CRUD + 2
    public List<DoneOrder> getAllFromDoneOrder() throws SQLException {
        return repository.getAllFromDoneOrder();
    }
    public String deleteAllFromDoneOrder() throws SQLException {
        repository.deleteAllFromDoneOrder();
        return "deleteAllFromDoneOrder is successful";
    }
    public String insertDoneOrder(DoneOrder doneOrder) throws SQLException {
        repository.insertDoneOrder(doneOrder);
        return "insertDoneOrder is successful";
    }
    public String deleteDoneOrder(int id) throws SQLException {
        repository.deleteDoneOrder(id);
        return "deleteDoneOrder is successful";
    }
    public String updateDoneOrder(DoneOrder doneOrder) throws SQLException {
        repository.updateDoneOrder(doneOrder);
        return "updateDoneOrder is successful";
    }
    public List<DoneOrder> getByIdFromDoneOrder(int id) throws SQLException {
        return repository.getByIdFromDoneOrder(id);
    }




    //Orders(6) - CRUD + 2
    public List<Orders> getAllFromOrders() throws SQLException {
        return repository.getAllFromOrders();
    }
    public String deleteAllFromOrders() throws SQLException {
        repository.deleteAllFromOrders();
        return "deleteAllFromOrders is successful";
    }
    public String insertOrders(Orders orders) throws SQLException {
        repository.insertOrders(orders);
        return "insertOrders is successful";
    }
    public String deleteOrders(int id) throws SQLException {
        repository.deleteOrders(id);
        return "deleteOrders is successful";
    }
    public String updateOrders(Orders orders) throws SQLException {
        repository.updateOrders(orders);
        return "updateOrders is successful";
    }
    public List<Orders> getByIdFromOrders(int id) throws SQLException {
        return repository.getByIdFromOrders(id);
    }




    //******************************************  LOGIC_of_Project  ********************************************
    public String insertClient_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        repository.insertClient_ConfirmOrder(confirmOrder);
        return "insertClient_ConfirmOrder(LOGIC) is successful";
    }
    public String updateAdmin_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException {
        repository.updateAdmin_ConfirmOrder(confirmOrder);
        return "updateAdmin_ConfirmOrder(LOGIC) is successful";
    }
    public String getByIdAdmin_ConfirmOrder(int id) throws SQLException {
        return repository.getByIdAdmin_ConfirmOrder(id);
    }


    //Проверка
    public String getByIdAdmin_CheckComponent(int id) throws SQLException {
        return repository.getByIdAdmin_CheckComponent(id);
    }


    public String updateClientFeedback_Orders(Orders orders) throws SQLException {
        repository.updateClientFeedback_Orders(orders);
        return "updateClientFeedback_DoneOrder(LOGIC) is successful";
    }







    //Дополнительные методы (+2)
    public String updateAdmin_DoneOrder(DoneOrder doneOrder) throws SQLException {
        repository.updateAdmin_DoneOrder(doneOrder);
        return "updateAdmin_DoneOrder(LOGIC) is successful";
    }
    public String getByIdAdmin_CheckDoneOrder(int id) throws SQLException {
        return repository.getByIdAdmin_CheckDoneOrder(id);
    }



}