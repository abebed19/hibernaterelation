package com.abbayllc.entities;

import jakarta.persistence.*;

@Entity(name = "users")
@SecondaryTable(
        name="user_detail",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(table = "user_detail")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
