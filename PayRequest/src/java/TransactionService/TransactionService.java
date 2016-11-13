/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionService;

import Config.DBConfig;
import TicketService.Ticket;
import TicketService.TicketService;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author alberttriadrian
 */
@WebService(serviceName = "TransactionService")
public class TransactionService {
    private String dbAddress = DBConfig.dbAdress;
    private String dbUsername = DBConfig.dbUsername;
    private String dbPassword = DBConfig.dbPassword;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "createTransaction")
    @WebResult(name = "Transaction")
    public Transaction createTransaction(@WebParam(name = "ID") int ID, @WebParam(name = "eventID") int eventID, @WebParam(name = "totalPrice") double totalPrice, @WebParam(name = "email") String email, @WebParam(name = "externalID") int externalID) {
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();

            String createTransactionQuery = "INSERT INTO transactions (event_id, total_price, email, external_id) VALUES (?, ?, ?, ?)";
            PreparedStatement createTransactionStatement = connection.prepareStatement(createTransactionQuery);
            createTransactionStatement.setInt(1, eventID);
            createTransactionStatement.setDouble(2, totalPrice);
            createTransactionStatement.setString(3, email);
            createTransactionStatement.setInt(4, externalID);
            createTransactionStatement.executeUpdate();
            
            String getTransactionQuery = "SELECT * FROM transactions WHERE event_id = ? AND email= ?";
            PreparedStatement getTransactionStatement = connection.prepareStatement(getTransactionQuery);
            getTransactionStatement.setInt(1, eventID);
            getTransactionStatement.setString(2, email);
            ResultSet result = getTransactionStatement.executeQuery();
            
            if (result.next()) {
                int Id = result.getInt("id");
                int eventId = result.getInt("event_id");
                double resultTotalPrice = result.getDouble("total_price");
                String resultEmail = result.getString("email");
                int externalId = result.getInt("external_id");
                String status = result.getString("status");
                
                Transaction transaction = new Transaction(Id, eventId, resultTotalPrice, resultEmail, externalId, status);

                result.close();
                statement.close();
                connection.close();            
                
                return transaction;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "completeTransaction")
    @WebResult(name = "Transaction")
    public Transaction completeTransaction(@WebParam(name = "transactionID") int transactionID) {
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String completeTransactionQuery = "UPDATE transactions SET status = ? WHERE id = ?";
            PreparedStatement completeTransactionStatement = connection.prepareStatement(completeTransactionQuery);
            completeTransactionStatement.setString(1, "COMPLETED");
            completeTransactionStatement.executeUpdate();

            String getTransactionQuery = "SELECT * FROM transactions WHERE id = ?";
            PreparedStatement getTransactionStatement = connection.prepareStatement(getTransactionQuery);
            getTransactionStatement.setInt(1, transactionID);
            ResultSet result = getTransactionStatement.executeQuery();
            
            if (result.next()) {
                int Id = result.getInt("id");
                int eventId = result.getInt("event_id");
                double resultTotalPrice = result.getDouble("total_price");
                String resultEmail = result.getString("email");
                int externalId = result.getInt("external_id");
                String status = result.getString("status");
                
                Transaction transaction = new Transaction(Id, eventId, resultTotalPrice, resultEmail, externalId, status);

                result.close();
                statement.close();
                connection.close();            
                
                return transaction;
            }
            
        } catch (SQLException ex){
            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return null;
    }
}
