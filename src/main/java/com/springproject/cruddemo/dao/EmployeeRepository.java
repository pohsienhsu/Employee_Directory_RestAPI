package com.springproject.cruddemo.dao;

import com.springproject.cruddemo.entity.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

}
