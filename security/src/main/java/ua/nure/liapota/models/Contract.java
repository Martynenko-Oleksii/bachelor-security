package ua.nure.liapota.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contract{
    @Id
    private int id;
    private String name;
    private String description;
    private byte duration;
    private byte start;

    public Contract(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public byte getStart() {
        return start;
    }

    public void setStart(byte start) {
        this.start = start;
    }
}
