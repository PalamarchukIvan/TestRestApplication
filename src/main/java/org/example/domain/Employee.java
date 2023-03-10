package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {//сущность БД
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//id даеться последовательно
    private Integer id;
    private String name;
}
