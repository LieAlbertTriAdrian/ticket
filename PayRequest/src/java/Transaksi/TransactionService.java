/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import transactionservice.Refund;
import transactionservice.Transaction;

/**
 *
 * @author zainelwati
 */
@WebService(serviceName = "TransactionService")
public class TransactionService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "refundTicket")
    public Refund refundTicket(@WebParam(name = "referenceID") int referenceID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "payWithPayPal")
    public Transaction payWithPayPal(@WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "amount") double amount) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "payWithCreditCard")
    public Transaction payWithCreditCard(@WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "amount") double amount) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createTransaction")
    public Transaction createTransaction(@WebParam(name = "price") float price, @WebParam(name = "quantity") int quantity, @WebParam(name = "eventName") String eventName, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTransaction")
    public Transaction getTransaction(@WebParam(name = "transactionID") int transactionID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateTransaction")
    public Transaction updateTransaction(@WebParam(name = "transactionID") int transactionID, @WebParam(name = "price") double price, @WebParam(name = "quantity") int quantity, @WebParam(name = "eventName") String eventName, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteTransaction")
    public Transaction deleteTransaction(@WebParam(name = "transactionID") int transactionID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "setTransactionStatus")
    public Transaction setTransactionStatus(@WebParam(name = "transactionID") int transactionID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPaymentStatus")
    public Payment getPaymentStatus(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "quantity") int quantity, @WebParam(name = "totalPrice") double totalPrice, @WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "paymentType") String paymentType, @WebParam(name = "currency") String currency, @WebParam(name = "status") String status) {
        //TODO write your implementation code here:
        return null;
    }

}
