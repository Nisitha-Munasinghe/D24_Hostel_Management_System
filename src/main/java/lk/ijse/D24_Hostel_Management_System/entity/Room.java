package lk.ijse.D24_Hostel_Management_System.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id", nullable = false, length = 50)
    private String roomId;

    private String roomType;

    private double pricing;

    private double roomSize;

    private int maximumOccupency;

    private String armentiesAndFeatures;

    private String roomStatus;

    @CreationTimestamp
    private Timestamp createdDateTime;

    public Room() {
    }

    public Room(String roomId, String roomType, double pricing, double roomSize, int maximumOccupency, String armentiesAndFeatures, String roomStatus, Timestamp createdDateTime) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.pricing = pricing;
        this.roomSize = roomSize;
        this.maximumOccupency = maximumOccupency;
        this.armentiesAndFeatures = armentiesAndFeatures;
        this.roomStatus = roomStatus;
        this.createdDateTime = createdDateTime;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(double roomSize) {
        this.roomSize = roomSize;
    }

    public int getMaximumOccupency() {
        return maximumOccupency;
    }

    public void setMaximumOccupency(int maximumOccupency) {
        this.maximumOccupency = maximumOccupency;
    }

    public String getArmentiesAndFeatures() {
        return armentiesAndFeatures;
    }

    public void setArmentiesAndFeatures(String armentiesAndFeatures) {
        this.armentiesAndFeatures = armentiesAndFeatures;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", pricing=" + pricing +
                ", roomSize=" + roomSize +
                ", maximumOccupency=" + maximumOccupency +
                ", armentiesAndFeatures='" + armentiesAndFeatures + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
