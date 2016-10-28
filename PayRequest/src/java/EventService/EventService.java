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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
            
//            if (eventOrganizer != null) {
//                eventOrganizer = eventOrganizer.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
//            }
//            if (location != null) {
//                location = location.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
//            }
//            if (name != null) {
//                name = name.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
//            }
            
            boolean filterFound = false;
            String getEventsQuery = "SELECT * FROM events ";
            if (eventOrganizer != null) {
                filterFound = true;
                getEventsQuery += "INNER JOIN users ON users.id = events.userID WHERE users.name LIKE ? ";
            }
            if (name != null) {
                filterFound = true;
                if (!filterFound) {
                    getEventsQuery += "WHERE events.name LIKE ? ";
                } else {
                    getEventsQuery += "AND events.name LIKE ? ";
                }
            }
            if (location != null) {
                if (!filterFound) {
                    getEventsQuery += "WHERE ";
                } else {
                  getEventsQuery += "AND ";
                }
                getEventsQuery += "(events.address LIKE ? OR events.city LIKE ? OR events.state LIKE ? OR events.country LIKE ?) ";
            }
            
            int n = 1;
            PreparedStatement getEventsStatement = connection.prepareStatement(getEventsQuery);
            if (eventOrganizer != null) {
                getEventsStatement.setString(n, "%" + eventOrganizer + "%");
                n++;
            }
            if (name != null) {
                getEventsStatement.setString(n, "%" + name + "%");
                n++;
            }
            if (location != null) {
                getEventsStatement.setString(n, "%" + location + "%");
                getEventsStatement.setString(n + 1, "%" + location + "%");
                getEventsStatement.setString(n + 2, "%" + location + "%");
                getEventsStatement.setString(n + 3, "%" + location + "%");
                n += 4;
            }
            System.out.println(getEventsStatement);
////                    + "AND (address LIKE ? OR city LIKE ? OR state LIKE ? OR country LIKE ?) ESCAPE '!'";
////            PreparedStatement getEventsStatement = connection.prepareStatement(getEventsQuery);
//            getEventsStatement.setString(1, name);
            ResultSet rs = getEventsStatement.executeQuery();
        
            while(rs.next()){
                int ID = rs.getInt("ID");
                String _name = rs.getString("name");
                String _address = rs.getString("address");
                String _city = rs.getString("city");
                String _state = rs.getString("state");
                String _country = rs.getString("country");
                int _postalCode = rs.getInt("postalCode");
                String _description = rs.getString("description");
                String _pictureUrl = rs.getString("pictureUrl");
                String _status = rs.getString("status");
                String _tags = rs.getString("tags");
                String _type = rs.getString("type");
                int _userID = rs.getInt("userID");
                Date _created = (rs.getTimestamp("created") != null) ? new Date(rs.getTimestamp("created").getTime()) : null;
                Date _updated = (rs.getTimestamp("updated") != null) ? new Date(rs.getTimestamp("created").getTime()) : null;
                Date _startTime = (rs.getTimestamp("startTime") != null) ? new Date(rs.getTimestamp("startTime").getTime()) : null;
                Date _endTime = (rs.getTimestamp("endTime") != null) ? new Date(rs.getTimestamp("endTime").getTime()) : null;
                
                Event event = new Event (ID, _address, _city, _country, _created,
                        _description, _endTime, _name, _pictureUrl,
                        _postalCode, _startTime, _state, _status,
                        _tags, _type, _userID, _updated);
                
                events.add(event);
            }
            rs.close();
            statement.close();
            connection.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    @WebMethod(operationName = "deleteEvent")
    @WebResult(name = "Event")
    public String deleteEvent(@WebParam(name = "ID") int ID) {
        String status = "";
        
        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String deleteEventQuery = "DELETE  FROM events WHERE id = ? ";
            PreparedStatement getEventsStatement = connection.prepareStatement(deleteEventQuery);
            getEventsStatement.setInt(1, ID);
            getEventsStatement.executeUpdate();
            status = "success";
        } catch (SQLException ex) {
            status = "failed";
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
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
        @WebParam(name = "startTime") String startTime,
        @WebParam(name = "endTime") String endTime
    ) throws ParseException {

        Event event = null;

        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String createEventQuery = "INSERT INTO events (name, address, city, state,"
                    + " country, postalCode, description, pictureUrl, status, tags, type, userID,"
                    + " startTime, endTime, created, updated) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
            PreparedStatement createEventStatement = connection.prepareStatement(createEventQuery, Statement.RETURN_GENERATED_KEYS);
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
            createEventStatement.setDate(13, new java.sql.Date(format.parse(startTime).getTime()));
            createEventStatement.setDate(14, new java.sql.Date(format.parse(endTime).getTime()));
            createEventStatement.setDate(15, new java.sql.Date(new Date().getTime()));
            createEventStatement.setDate(16, new java.sql.Date(new Date().getTime()));
            createEventStatement.executeUpdate();
            ResultSet rs = createEventStatement.getGeneratedKeys();
            
            int eventID = 0;
            while (rs.next()) {
                eventID = rs.getInt(1);
            }
            
            if (eventID != 0) {
                event = getEventDetailData(eventID);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }

    
    @WebMethod(operationName = "editEvent")
    @WebResult(name = "Event")
    public Event editEvent(
        @WebParam(name = "ID") int ID,
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
        @WebParam(name = "startTime") String startTime,
        @WebParam(name = "endTime") String endTime
    ) throws ParseException {
        Event event = new Event();

        try {
            new Driver();
            Connection connection = DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
            Statement statement = connection.createStatement();
            
            String editEventQuery = "UPDATE events SET name = ?, address = ?, city = ?, state = ?,"
                    + " country = ?, postalCode = ?, description = ?, pictureUrl = ?, status = ?, tags = ?,"
                    + " type = ?, userID = ?, startTime  = ?, endTime = ? WHERE ID = ?";

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
            PreparedStatement editEventStatement = connection.prepareStatement(editEventQuery);
            editEventStatement.setString(1, name);
            editEventStatement.setString(2, address);
            editEventStatement.setString(3, city);
            editEventStatement.setString(4, state);
            editEventStatement.setString(5, country);
            editEventStatement.setInt(6, postalCode);
            editEventStatement.setString(7, description);
            editEventStatement.setString(8, pictureUrl);
            editEventStatement.setString(9, status);
            editEventStatement.setString(10, tags);
            editEventStatement.setString(11, type);
            editEventStatement.setInt(12, userID);
            editEventStatement.setDate(13, new java.sql.Date(format.parse(startTime).getTime()));
            editEventStatement.setDate(14, new java.sql.Date(format.parse(endTime).getTime()));
            editEventStatement.setInt(15, ID);
            System.out.println(editEventStatement);
            editEventStatement.executeUpdate();
            
            event = getEventDetailData(ID);
            
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }

    @WebMethod(operationName = "getEventDetail")
    @WebResult(name = "Event")
    public Event getEventDetail(@WebParam(name = "ID") int ID) {
        Event event = getEventDetailData(ID);
        return event;
    }

    private Event getEventDetailData(int ID) {
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
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }

}
