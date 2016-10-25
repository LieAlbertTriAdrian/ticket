/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import javax.jws.WebService;

/**
 *
 * @author zainelwati
 */
@WebService(serviceName = "TransactionService", portName = "TransactionServicePort", endpointInterface = "transactionservice.TransactionService", targetNamespace = "http://TransactionService/", wsdlLocation = "WEB-INF/wsdl/NewWebServiceFromWSDL/TransactionService.wsdl")
public class TransactionServiceFromWSDL {

    public transactionservice.Refund refundTicket(java.lang.String referenceId) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public transactionservice.Transaction payWithPaypal(java.lang.String accountNumber, double amount) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public transactionservice.Transaction payWithCreditCard(java.lang.String accountNumber, java.lang.String amount) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }    
}
