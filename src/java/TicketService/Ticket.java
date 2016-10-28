/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TicketService;

import java.util.Date;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author alberttriadrian
 */

@XmlRootElement(name = "Ticket")
public class Ticket {
    @XmlElement(name="ID", required=true)
    private int ID;
    @XmlElement(name="eventID", required=true)
    private int eventID;
    @XmlElement(name="userID", required=true)
    private int userID;
    @XmlElement(name="transactionID", required=true)
    private int transactionID;
    @XmlElement(name="type", required=true)
    private String type;
    @XmlElement(name="price", required=true)
    private double price;
    @XmlElement(name="firstName", required=true)
    private String firstName;
    @XmlElement(name="lastName", required=true)
    private String lastName;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="created", required=true)
    private Date created;
    @XmlElement(name="updated", required=true)
    private Date updated;
    @XmlElement(name="status", required=true)
    private String status;

    public Ticket () {}
    
    public Ticket(int ID, int eventID, int userID, int transactionID, String type, double price, String firstName, String lastName, String email, Date created, Date updated, String status) {
        this.ID = ID;
        this.eventID = eventID;
        this.userID = userID;
        this.transactionID = transactionID;
        this.type = type;
        this.price = price;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }
}