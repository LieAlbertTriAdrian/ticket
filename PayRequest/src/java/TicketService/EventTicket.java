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

@XmlRootElement(name = "EventTicket")
public class EventTicket {
    @XmlElement(name="ID", required=true)
    private int ID;
    @XmlElement(name="eventID", required=true)
    private int eventID;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="description", required=true)
    private String description;
    @XmlElement(name="price", required=true)
    private double price;
    @XmlElement(name="left", required=true)
    private int left;

    public EventTicket () {}
    
    public EventTicket(int ID, int eventID, String name, String description, double price, int left) {
        this.ID = ID;
        this.eventID = eventID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.left = left;
    }
}