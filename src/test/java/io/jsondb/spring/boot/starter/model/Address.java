package io.jsondb.spring.boot.starter.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(schemaVersion = "1.0", collection = "Address")
public class Address {
    private String name;
    @Id
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
