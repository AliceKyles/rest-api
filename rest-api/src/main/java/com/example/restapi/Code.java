package com.example.restapi;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "Codes")
public class Code {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long id;


    @Column(name = "code")
    public int code;
}
