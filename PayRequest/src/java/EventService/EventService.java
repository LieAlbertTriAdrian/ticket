/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventService;

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
@WebService(serviceName = "EventService")
public class EventService {
    private String dbAddress = DBConfig.dbAdress;
    private String dbUsername = DBConfig.dbUsername;
    private String dbPassword = DBConfig.dbPassword;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getEvents")
    @WebResult(name = "Event")
    public List<Event> getEvents(
        @WebParam(name = "eventOrganizer") String eventOrganizer,
        @WebParam(name = "location") String location,
        @WebParam(name = "name") String name,
        @WebParam(name = "type") String type
    ) {
        List<Event> events = new ArrayList<Event>();
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            eventOrganizer = eventOrganizer.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            location = location.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            name = name.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
            
            String getEventsQuery = "SELECT * FROM events WHERE name LIKE ? "
                    + "AND (address LIKE ? OR city LIKE ? OR state LIKE ? OR country LIKE ?) ESCAPE '!'";
            PreparedStatement getEventsStatement = connection.prepareStatement(getEventsQuery);
            getEventsStatement.setString(1, name);
            ResultSet rs = getEventsStatement.executeQuery();
        
            while(rs.next()){
                Event e = new Event();
                events.add(e);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    public Event delete(java.lang.String id) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    @WebMethod(operationName = "createEvent")
    @WebResult(name = "Event")
    public Event createEvent(
        @WebParam(name = "name") String name,
        @WebParam(name = "address") String address,
        @WebParam(name = "city") String city,
        @WebParam(name = "state") String state,
        @WebParam(name = "country") String country,
        @WebParam(name = "postalCode") int postalCode,
        @WebParam(name = "description") String description,
        @WebParam(name = "pictureUrl") String pictureUrl,
        @WebParam(name = "status") String status,
        @WebParam(name = "tags") String tags,
        @WebParam(name = "type") String type,
        @WebParam(name = "userID") int userID,
        @WebParam(name = "startTime") Date startTime,
        @WebParam(name = "endTime") Date endTime
    ) {

        Event event = null;

        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String createEventQuery = "INSERT INTO events (name, address, city, state,"
                    + " country, postalCode, description, pictureUrl, status, tags, type, userID,"
                    + " startTime, endTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement createEventStatement = connection.prepareStatement(createEventQuery);
            createEventStatement.setString(1, name);
            createEventStatement.setString(2, address);
            createEventStatement.setString(3, city);
            createEventStatement.setString(4, state);
            createEventStatement.setString(5, country);
            createEventStatement.setInt(6, postalCode);
            createEventStatement.setString(7, description);
            createEventStatement.setString(8, pictureUrl);
            createEventStatement.setString(9, status);
            createEventStatement.setString(10, tags);
            createEventStatement.setString(11, type);
            createEventStatement.setInt(12, userID);
            createEventStatement.setDate(13, new java.sql.Date(startTime.getTime()));
            createEventStatement.setDate(14, new java.sql.Date(endTime.getTime()));
            createEventStatement.executeUpdate();
            ResultSet rs = createEventStatement.getGeneratedKeys();
            
            int eventID = 0;
            while (rs.next()) {
                eventID = rs.getInt(1);
            }
            
            if (eventID != 0) {
                String getEventQuery = "SELECT * FROM events WHERE id = ?";
                PreparedStatement getEventStatement = connection.prepareStatement(getEventQuery);
                getEventStatement.setInt(1, eventID);
                ResultSet rs2 = getEventStatement.executeQuery();
                
                if (rs2.next()) {
                    int ID = rs2.getInt("id");
                    String _name = rs2.getString("name");
                    String _address = rs2.getString("address");
                    String _city = rs2.getString("city");
                    String _state = rs2.getString("state");
                    String _country = rs2.getString("country");
                    int _postalCode = rs2.getInt("postalCode");
                    String _description = rs2.getString("description");
                    String _pictureUrl = rs2.getString("pictureUrl");
                    String _status = rs2.getString("status");
                    String _tags = rs2.getString("tags");
                    String _type = rs2.getString("type");
                    int _userID = rs2.getInt("userID");
                    Date _created = new Date(rs2.getTimestamp("created").getTime());
                    Date _updated = new Date(rs2.getTimestamp("updated").getTime());
                    Date _startTime = new Date(rs2.getTimestamp("startTime").getTime());
                    Date _endTime = new Date(rs2.getTimestamp("endTime").getTime());

                    event = new Event (ID, _address, _city, _country, _created,
                            _description, _endTime, _name, _pictureUrl,
                            _postalCode, _startTime, _state, _status,
                            _tags, _type, _userID, _updated);

                    rs2.close();
                    statement.close();
                    connection.close();   
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }

    public Event edit(java.lang.String address, java.lang.String city, java.lang.String country, javax.xml.datatype.XMLGregorianCalendar createdDate, java.lang.String description, javax.xml.datatype.XMLGregorianCalendar eventTimeEnd, javax.xml.datatype.XMLGregorianCalendar eventTimeStart, java.lang.String id, java.lang.String name, java.lang.String pictureUrl, java.lang.String postalCode, java.lang.String state, java.lang.String status, java.util.List<java.lang.String> tags, java.lang.String type, javax.xml.datatype.XMLGregorianCalendar udpatedDate, java.lang.String userId) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @WebMethod(operationName = "getEventDetail")
    @WebResult(name = "Event")
    public Event getEventDetail(@WebParam(name = "ID") int ID) {
        
        Event event = null;

        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String getEventDetailQuery = "SELECT * FROM events WHERE id = ?";
            PreparedStatement getEventDetailStatement = connection.prepareStatement(getEventDetailQuery);
            getEventDetailStatement.setInt(1, ID);
            ResultSet result = getEventDetailStatement.executeQuery();
            
            if (result.next()) {

                String name = result.getString("name");
                String address = result.getString("address");
                String city = result.getString("city");
                String state = result.getString("state");
                String country = result.getString("country");
                int postalCode = result.getInt("postalCode");
                String description = result.getString("description");
                String pictureUrl = result.getString("pictureUrl");
                String status = result.getString("status");
                String tags = result.getString("tags");
                String type = result.getString("type");
                int userID = result.getInt("userID");
                Date created = new Date(result.getTimestamp("created").getTime());
                Date updated = new Date(result.getTimestamp("updated").getTime());
                Date startTime = new Date(result.getTimestamp("startTime").getTime());
                Date endTime = new Date(result.getTimestamp("endTime").getTime());
                                                
                event = new Event (ID, address, city, country, created,
                        description, endTime, name, pictureUrl,
                        postalCode, startTime, state, status,
                        tags, type, userID, updated);

                result.close();
                statement.close();
                connection.close();            
                
                return event;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }


}
