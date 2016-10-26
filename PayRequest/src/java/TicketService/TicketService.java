/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicketService;

import Config.DBConfig;
import com.mysql.jdbc.Driver;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author alberttriadrian
 */
import java.util.logging.Level;
import java.util.logging.Logger;
@WebService(serviceName = "TicketService")
public class TicketService {
    private String dbAddress = DBConfig.dbAdress;
    private String dbUsername = DBConfig.dbUsername;
    private String dbPassword = DBConfig.dbPassword;

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
    public Ticket createTicket(@WebParam(name = "eventID") int eventID, @WebParam(name = "userID") int userID, @WebParam(name = "transactionID") int transactionID, @WebParam(name = "type") String type, @WebParam(name = "price") double price, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "email") String email) {
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();

            String createTicketQuery = "INSERT INTO tickets (event_id, user_id, transaction_id, type, price, first_name, last_name, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement createTicketStatement = connection.prepareStatement(createTicketQuery);
            createTicketStatement.setInt(1, eventID);
            createTicketStatement.setInt(2, userID);
            createTicketStatement.setInt(3, transactionID);
            createTicketStatement.setString(4, type);
            createTicketStatement.setDouble(5, price);
            createTicketStatement.setString(6, firstName);
            createTicketStatement.setString(7, lastName);
            createTicketStatement.setString(8, email);
            createTicketStatement.executeUpdate();
            
            String getTicketQuery = "SELECT * FROM tickets WHERE event_id = ? AND user_id = ? AND transaction_id = ?";
            PreparedStatement getTicketStatement = connection.prepareStatement(getTicketQuery);
            getTicketStatement.setInt(1, eventID);
            getTicketStatement.setInt(2, userID);
            getTicketStatement.setInt(3, transactionID);
            ResultSet result = getTicketStatement.executeQuery();
            
            if (result.next()) {
                int ID = result.getInt("id");
                int eventId = result.getInt("event_id");
                int userId = result.getInt("user_id");
                int transactionId = result.getInt("transaction_id");
                String resultType = result.getString("type");
                double resultPrice = result.getDouble("price");
                String resultFirstName = result.getString("first_name");
                String resultLastName = result.getString("last_name");
                String resultEmail = result.getString("email");
                Date created = new Date(result.getTimestamp("created").getTime());
                Date updated = new Date(result.getTimestamp("updated").getTime());
                String status = result.getString("status");
                                                
                Ticket ticket = new Ticket(ID, eventId, userId, transactionId, resultType, resultPrice, resultFirstName, resultLastName, resultEmail , created, updated, status);

                result.close();
                statement.close();
                connection.close();            
                
                return ticket;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTicketsByUserID")
    @WebResult(name = "Ticket")
    public ArrayList<Ticket> getTicketsByUserID(@WebParam(name = "userID") int userID) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String getTicketsByUserIdQuery = "SELECT * FROM tickets WHERE user_id = ?";
            PreparedStatement getTicketsByUserIdStatement = connection.prepareStatement(getTicketsByUserIdQuery);
            getTicketsByUserIdStatement.setInt(1, userID);
            ResultSet result = getTicketsByUserIdStatement.executeQuery();
            
            while (result.next()) {
                int ID = result.getInt("id");
                int eventID = result.getInt("event_id");
                int userId = result.getInt("user_id");
                int transactionID = result.getInt("transaction_id");
                String type = result.getString("type");
                double price = result.getDouble("price");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                Date created = new Date(result.getTimestamp("created").getTime());
                Date updated = new Date(result.getTimestamp("updated").getTime());
                String status = result.getString("status");
                                                
                Ticket ticket = new Ticket(ID, eventID, userId, transactionID, type, price, firstName, lastName, email , created, updated, status);
                tickets.add(ticket);
            }
            
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex){
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return tickets;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTicketsByEventID")
    @WebResult(name = "Ticket")
    public ArrayList<Ticket> getTicketsByEventID(@WebParam(name = "eventID") int eventID) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String getTicketsByEventIdQuery = "SELECT * FROM tickets WHERE event_id = ?";
            PreparedStatement getTicketsByEventIdStatement = connection.prepareStatement(getTicketsByEventIdQuery);
            getTicketsByEventIdStatement.setInt(1, eventID);
            ResultSet result = getTicketsByEventIdStatement.executeQuery();
            
            while (result.next()) {
                int ID = result.getInt("id");
                int eventId = result.getInt("event_id");
                int userID = result.getInt("user_id");
                int transactionID = result.getInt("transaction_id");
                String type = result.getString("type");
                double price = result.getDouble("price");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                Date created = new Date(result.getTimestamp("created").getTime());
                Date updated = new Date(result.getTimestamp("updated").getTime());
                String status = result.getString("status");
                                                
                Ticket ticket = new Ticket(ID, eventId, userID, transactionID, type, price, firstName, lastName, email , created, updated, status);
                tickets.add(ticket);
            }
            
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex){
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return tickets;
    }    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelTicket")
    @WebResult(name = "Ticket")
    public Ticket cancelTicket(@WebParam(name = "ticketID") int ticketID) {
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String cancelTicketQuery = "UPDATE tickets SET status = ? WHERE id = ?";
            PreparedStatement cancelTicketStatement = connection.prepareStatement(cancelTicketQuery);
            cancelTicketStatement.setString(1, "CANCELLED");
            cancelTicketStatement.setInt(2, ticketID);
            cancelTicketStatement.executeUpdate();

            String getTicketQuery = "SELECT * FROM tickets WHERE id = ?";
            PreparedStatement getTicketStatement = connection.prepareStatement(getTicketQuery);
            getTicketStatement.setInt(1, ticketID);
            ResultSet result = getTicketStatement.executeQuery();
            
            if (result.next()) {
                int ID = result.getInt("id");
                int eventID = result.getInt("event_id");
                int userId = result.getInt("user_id");
                int transactionID = result.getInt("transaction_id");
                String type = result.getString("type");
                double price = result.getDouble("price");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");
                Date created = new Date(result.getTimestamp("created").getTime());
                Date updated = new Date(result.getTimestamp("updated").getTime());
                String status = result.getString("status");
                                                
                Ticket ticket = new Ticket(ID, eventID, userId, transactionID, type, price, firstName, lastName, email , created, updated, status);
                result.close();
                statement.close();
                connection.close();

                return ticket;
            }
            
        } catch (SQLException ex){
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return null;
    }    
}
