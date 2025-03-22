package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {

    public Customer(String id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }


    private String id;

    private  String name;

    private String address;

    private Double salary;

}
