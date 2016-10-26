/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventService;

import javax.jws.WebService;

/**
 *
 * @author ivan
 */
@WebService(serviceName = "EventService", portName = "EventServicePort", endpointInterface = "eventservice.EventService", targetNamespace = "http://EventService/", wsdlLocation = "WEB-INF/wsdl/EventService/EventService.wsdl")
public class EventService {

    public java.util.List<eventservice.Event> get(java.lang.String eventOrganizer, java.lang.String location, java.lang.String name, java.lang.String type) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public eventservice.Event delete(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public eventservice.Event create(java.lang.String address, java.lang.String city, java.lang.String country, javax.xml.datatype.XMLGregorianCalendar createdDate, java.lang.String description, javax.xml.datatype.XMLGregorianCalendar eventTimeEnd, javax.xml.datatype.XMLGregorianCalendar eventTimeStart, java.lang.String name, java.lang.String pictureUrl, java.lang.String postalCode, java.lang.String state, java.lang.String status, java.util.List<java.lang.String> tags, java.lang.String type, javax.xml.datatype.XMLGregorianCalendar udpatedDate, java.lang.String userId) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public eventservice.Event edit(java.lang.String address, java.lang.String city, java.lang.String country, javax.xml.datatype.XMLGregorianCalendar createdDate, java.lang.String description, javax.xml.datatype.XMLGregorianCalendar eventTimeEnd, javax.xml.datatype.XMLGregorianCalendar eventTimeStart, java.lang.String id, java.lang.String name, java.lang.String pictureUrl, java.lang.String postalCode, java.lang.String state, java.lang.String status, java.util.List<java.lang.String> tags, java.lang.String type, javax.xml.datatype.XMLGregorianCalendar udpatedDate, java.lang.String userId) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public eventservice.Event getDetail(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
