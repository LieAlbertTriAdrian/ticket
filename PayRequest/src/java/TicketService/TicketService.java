/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketService;

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author alberttriadrian
 */
@WebService(serviceName = "TicketService")
public class TicketService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createTicket")
    @WebResult(name = "Ticket")
    public Ticket createTicket(@WebParam(name = "ID") int ID, @WebParam(name = "eventID") int eventID, @WebParam(name = "userID") int userID, @WebParam(name = "transactionID") int transactionID, @WebParam(name = "type") String type, @WebParam(name = "price") double price, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "email") String email, @WebParam(name = "created") Date created, @WebParam(name = "updated") Date updated, @WebParam(name = "status") String status) {
        //TODO write your implementation code here:
        return null;
    }
}
