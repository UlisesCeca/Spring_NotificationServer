package com.ulises.notificationsserver.services.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Emails")
public class Context {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
