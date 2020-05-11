package com.cs5446.tm.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ap_day_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleTimeStamp;

    @Column(name = "location",nullable = false)
    private String location;

    public Appointment(Date scheduleTimeStamp, String location) {
        this.scheduleTimeStamp = scheduleTimeStamp;
        this.location = location;
    }

    public Appointment() {
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Date getScheduleTimeStamp() {
        return scheduleTimeStamp;
    }

    public void setScheduleTimeStamp(Date scheduleTimeStamp) {
        this.scheduleTimeStamp = scheduleTimeStamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
