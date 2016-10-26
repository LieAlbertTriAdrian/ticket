/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventService;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ivan
 */
@XmlRootElement(name = "Event")
public class Event {
    @XmlElement(name="address", required=true)
    private String address;
    @XmlElement(name="city", required=true)
    private String city;
    @XmlElement(name="country", required=true)
    private String country;
    @XmlElement(name="createdAt", required=true)
    private Date createdAt;
    @XmlElement(name="description", required=true)
    private String description;
    @XmlElement(name="endTime", required=true)
    private Date endTime;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="pictureUrl", required=true)
    private String pictureUrl;
    @XmlElement(name="postalCode", required=true)
    private int postalCode;
    @XmlElement(name="startTime", required=true)
    private Date startTime;
    @XmlElement(name="state", required=true)
    private String state;
    @XmlElement(name="status", required=true)
    private String status;
    @XmlElement(name="tags", required=true)
    private String tags;
    @XmlElement(name="type", required=true)
    private String type;
    @XmlElement(name="updatedAt", required=true)
    private Date updatedAt;
    @XmlElement(name="userId", required=true)
    private int userId;
    
    public Event() {
        
    }
    
    public Event(String address, String city, String country, Date createdAt,
            String description, Date endTime, String name, String pictureurl,
            int postalCode, Date startTime, String state, String status,
            String tags, String type, Date updatedAt, int userId) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.createdAt = createdAt;
        this.description = description;
        this.endTime = endTime;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.postalCode = postalCode;
        this.startTime = startTime;
        this.state = state;
        this.status = status;
        this.tags = tags;
        this.type = type;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setDescription(String country) {
        this.country = country;
    }
    
    public String getDescription() {
        return country;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    
    public String getPictureUrl() {
        return pictureUrl;
    }
    
    public void setPostal(int postalCode) {
        this.postalCode = postalCode;
    }
    
    public int getPostalCode() {
        return postalCode;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }

}

