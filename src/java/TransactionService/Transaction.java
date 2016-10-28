/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TransactionService;

import java.util.Date;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author alberttriadrian
 */

@XmlRootElement(name = "Transaction")
public class Transaction {
    @XmlElement(name="ID", required=true)
    private int ID;
    @XmlElement(name="eventID", required=true)
    private int eventID;
    @XmlElement(name="totalPrice", required=true)
    private double totalPrice;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="externalID", required=true)
    private int externalID;
    @XmlElement(name="status", required=true)
    private String status;

    public Transaction () {}
    
    public Transaction(int ID, int eventID, double totalPrice, String email, int externalID, String status) {
        this.ID = ID;
        this.eventID = eventID;
        this.totalPrice = totalPrice;
        this.email = email;
        this.externalID = externalID;
        this.status = status;
    }
}