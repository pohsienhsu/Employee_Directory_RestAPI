package com.springproject.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    // define fields
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;

    public Employee(ObjectId id) {
        this.id = id;
    }

    // define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
