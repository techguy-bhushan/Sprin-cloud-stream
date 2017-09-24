package com.producer.producer.util;


import java.util.Date;

public class UuidCaller {
    private Long id;

    @Override
    public String toString() {
        return "UuidCaller{" +
                "id=" + id +
                ", date=" + date +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    public UuidCaller() {
    }

    public UuidCaller(Long id, Date data, String uuid) {
        this.id = id;
        this.date = data;
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private Date date;
    private String uuid;
}
