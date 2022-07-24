package controller;

import model.Component;
import model.ConfirmOrder;
import model.DoneOrder;
import model.Orders;
import service.ServiceImpl;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/SupplyChainManagementSystem")
public class Controller extends HttpServlet {
    @Inject
    @EJB
    private ServiceImpl serviceImpl;
    @EJB
    private JmsLogic jmsLogic;

    //Dealer - CRUD
    @GET
    @Path("/Dealer/getAll")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Component> getAllFromDealer() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getAllFromDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getAllFromDealer - is already in Cache");
        }

        jmsLogic.sendMessage("getAllFromDealer is success");
        return serviceImpl.getAllFromDealer();
    }

    @POST
    @Path("/Dealer/save")
    @RolesAllowed("DEALER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertDealer(Component component) throws SQLException, JMSException {
        //Custom Exception
        if (component.getComponent().equals("")) {
            throw new CustomParameterConstraintException("Component is empty");
        }

        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","insertDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("insertDealer - is already in Cache");
        }

        jmsLogic.sendMessage("insertDealer is success");
        return Response.ok(serviceImpl.insertDealer(component)).build();
    }

    @DELETE
    @Path("/Dealer/delete/{id}")
    @RolesAllowed("DEALER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDealer(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteDealer - is already in Cache");
        }

        jmsLogic.sendMessage("deleteDealer is success");
        return Response.ok(serviceImpl.deleteDealer(id)).build();
    }

    @DELETE
    @Path("/Dealer/deleteAll")
    @RolesAllowed("DEALER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllFromDealer() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteAllFromDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteAllFromDealer - is already in Cache");
        }

        jmsLogic.sendMessage("deleteAllFromDealer is success");
        return Response.ok(serviceImpl.deleteAllFromDealer()).build();
    }

    @PUT
    @Path("/Dealer/update")
    @RolesAllowed("DEALER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDealer(Component component) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateDealer - is already in Cache");
        }

        jmsLogic.sendMessage("updateDealer is success");
        return Response.ok(serviceImpl.updateDealer(component)).build();
    }

    @GET
    @Path("/Dealer/getById/{id}")
    @RolesAllowed("DEALER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Component> getByIdFromDealer(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdFromDealer is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdFromDealer - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdFromDealer is success");
        return serviceImpl.getByIdFromDealer(id);
    }





    //ConfirmOrder - CRUD
    @GET
    @Path("/Client/confirmOrder/getAll")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfirmOrder> getAllFromConfirmOrder() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getAllFromConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getAllFromConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("getAllFromConfirmOrder is success");
        return serviceImpl.getAllFromConfirmOrder();
    }

    @DELETE
    @Path("/Client/confirmOrder/deleteAll")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllFromConfirmOrder() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteAllFromConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteAllFromConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("deleteAllFromConfirmOrder is success");
        return Response.ok(serviceImpl.deleteAllFromConfirmOrder()).build();
    }

    @POST
    @Path("/Client/confirmOrder/save")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertConfirmOrder(ConfirmOrder confirmOrder) throws SQLException, JMSException {
        //Custom Exception
        if (confirmOrder.getVideoCard().equals("") || confirmOrder.getProcessor().equals("") || confirmOrder.getRam().equals("")) {
            throw new CustomParameterConstraintException("Value of VideoCard or Processor or Ram is empty");
        }

        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","insertConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("insertConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("insertConfirmOrder is success");
        return Response.ok(serviceImpl.insertConfirmOrder(confirmOrder)).build();
    }

    @DELETE
    @Path("/Client/confirmOrder/delete/{id}")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteConfirmOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("deleteConfirmOrder is success");
        return Response.ok(serviceImpl.deleteConfirmOrder(id)).build();
    }

    @PUT
    @Path("/Client/confirmOrder/update")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDealer(ConfirmOrder confirmOrder) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("updateConfirmOrder is success");
        return Response.ok(serviceImpl.updateConfirmOrder(confirmOrder)).build();
    }

    @GET
    @Path("/Client/confirmOrder/getById/{id}")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfirmOrder> getByIdFromConfirmOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdFromConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdFromConfirmOrder - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdFromConfirmOrder is success");
        return serviceImpl.getByIdFromConfirmOrder(id);
    }





    //DoneOrder - CRUD
    @GET
    @Path("/Admin/doneOrder/getAll")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoneOrder> getAllFromDoneOrder() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getAllFromDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getAllFromDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("getAllFromDoneOrder is success");
        return serviceImpl.getAllFromDoneOrder();
    }

    @DELETE
    @Path("/Admin/doneOrder/deleteAll")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllFromDoneOrder() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteAllFromDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteAllFromDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("deleteAllFromDoneOrder is success");
        return Response.ok(serviceImpl.deleteAllFromDoneOrder()).build();
    }

    @POST
    @Path("/Admin/doneOrder/save")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertDoneOrder(DoneOrder doneOrder) throws SQLException, JMSException {
        //Custom Exception
        if (doneOrder.getVideoCard().equals("") || doneOrder.getProcessor().equals("") || doneOrder.getRam().equals("")) {
            throw new CustomParameterConstraintException("Value of VideoCard or Processor or Ram is empty");
        }

        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","insertDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("insertDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("insertDoneOrder is success");
        return Response.ok(serviceImpl.insertDoneOrder(doneOrder)).build();
    }

    @DELETE
    @Path("/Admin/doneOrder/delete/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDoneOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("deleteDoneOrder is success");
        return Response.ok(serviceImpl.deleteDoneOrder(id)).build();
    }

    @PUT
    @Path("/Admin/doneOrder/update")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDoneOrder(DoneOrder doneOrder) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("updateDoneOrder is success");
        return Response.ok(serviceImpl.updateDoneOrder(doneOrder)).build();
    }

    @GET
    @Path("/Admin/doneOrder/getById/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<DoneOrder> getByIdFromDoneOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdFromDoneOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdFromDoneOrder - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdFromDoneOrder is success");
        return serviceImpl.getByIdFromDoneOrder(id);
    }





    //Orders - CRUD
    @GET
    @Path("/Admin/orders/getAll")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getAllFromOrders() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getAllFromOrders is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getAllFromOrders - is already in Cache");
        }

        jmsLogic.sendMessage("getAllFromOrders is success");
        return serviceImpl.getAllFromOrders();
    }

    @DELETE
    @Path("/Admin/orders/deleteAll")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllFromOrders() throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteAllFromOrders is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteAllFromOrders - is already in Cache");
        }

        jmsLogic.sendMessage("deleteAllFromOrders is success");
        return Response.ok(serviceImpl.deleteAllFromOrders()).build();
    }

    @POST
    @Path("/Admin/orders/save")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertOrders(Orders orders) throws SQLException, JMSException {
        //Custom Exception
        if (orders.getVideoCard().equals("") || orders.getProcessor().equals("") || orders .getRam().equals("")) {
            throw new CustomParameterConstraintException("Value of VideoCard or Processor or Ram is empty");
        }

        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","insertOrders is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("insertOrders - is already in Cache");
        }

        jmsLogic.sendMessage("insertOrders is success");
        return Response.ok(serviceImpl.insertOrders(orders)).build();
    }

    @DELETE
    @Path("/Admin/orders/delete/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrders(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","deleteOrders is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("deleteOrders - is already in Cache");
        }

        jmsLogic.sendMessage("deleteOrders is success");
        return Response.ok(serviceImpl.deleteOrders(id)).build();
    }

    @PUT
    @Path("/Admin/orders/update")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrders(Orders orders) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getAllFromConfirmOrder is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateOrders - is already in Cache");
        }

        jmsLogic.sendMessage("updateOrders is success");
        return Response.ok(serviceImpl.updateOrders(orders)).build();
    }

    @GET
    @Path("/Admin/orders/getById/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getByIdFromOrders(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdFromOrders is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdFromOrders - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdFromOrders is success");
        return serviceImpl.getByIdFromOrders(id);
    }






    //******************************************  LOGIC_of_Project  ********************************************

    @POST
    @Path("/LOGIC/Client/confirmOrder/save")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertClient_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException, JMSException {
        //Custom Exception
        if (confirmOrder.getVideoCard().equals("") || confirmOrder.getProcessor().equals("") || confirmOrder .getRam().equals("")) {
            throw new CustomParameterConstraintException("Value of VideoCard or Processor or Ram is empty");
        }

        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","insertClient_ConfirmOrder(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("insertClient_ConfirmOrder(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("insertClient_ConfirmOrder(LOGIC) is success");
        return Response.ok(serviceImpl.insertClient_ConfirmOrder(confirmOrder)).build();
    }

    @PUT
    @Path("/LOGIC/Admin/confirmOrder/update/confirm")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdmin_ConfirmOrder(ConfirmOrder confirmOrder) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateAdmin_ConfirmOrder(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateAdmin_ConfirmOrder(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("updateAdmin_ConfirmOrder(LOGIC) is success");
        return Response.ok(serviceImpl.updateAdmin_ConfirmOrder(confirmOrder)).build();
    }

    @GET
    @Path("/LOGIC/Admin/confirmOrder/getById/check_confirm/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdAdmin_ConfirmOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateAdmin_ConfirmOrder(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateAdmin_ConfirmOrder(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdAdmin_ConfirmOrder(LOGIC) is success");
        return serviceImpl.getByIdAdmin_ConfirmOrder(id);
    }



    //Проверка
    @GET
    @Path("/LOGIC/Admin/doneOrder/getById/check_Component/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdAdmin_CheckComponent(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdAdmin_CheckComponent(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdAdmin_CheckComponent(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdAdmin_CheckComponent(LOGIC) is success");
        return serviceImpl.getByIdAdmin_CheckComponent(id);
    }


    @PUT
    @Path("/LOGIC/Client/orders/update/feedback")
    @RolesAllowed("CLIENT")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateClientFeedback_Orders(Orders orders) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateClientFeedback_Orders(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateClientFeedback_Orders(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("updateClientFeedback_Orders(LOGIC) is success");
        return Response.ok(serviceImpl.updateClientFeedback_Orders(orders)).build();
    }





    //Дополнительные методы (+2)
    @PUT
    @Path("/LOGIC/Admin/doneOrder/update/done")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdmin_DoneOrder(DoneOrder doneOrder) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","updateAdmin_DoneOrder(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("updateAdmin_DoneOrder(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("updateAdmin_DoneOrder(LOGIC) is success");
        return Response.ok(serviceImpl.updateAdmin_DoneOrder(doneOrder)).build();
    }

    @GET
    @Path("/LOGIC/Admin/doneOrder/getById/check_done/{id}")
    @RolesAllowed("ADMIN")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getByIdAdmin_CheckDoneOrder(@PathParam("id") int id) throws SQLException, JMSException {
        //Caching the method
        if (CacheLogic.CONSTANT_MAP.get("model") == null) {
            CacheLogic.CONSTANT_MAP.put("model","getByIdAdmin_CheckDoneOrder(LOGIC) is success");
            System.out.println(CacheLogic.CONSTANT_MAP.get("model"));
        } else {
            System.out.println("getByIdAdmin_CheckDoneOrder(LOGIC) - is already in Cache");
        }

        jmsLogic.sendMessage("getByIdAdmin_CheckDoneOrder(LOGIC) is success");
        return serviceImpl.getByIdAdmin_CheckDoneOrder(id);
    }







    @GET
    @Path("/jms")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getMessage() throws JMSException {
        return jmsLogic.getMessage();
    }
}
