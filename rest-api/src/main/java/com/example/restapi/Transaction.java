package com.example.restapi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;


@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @Column(name = "code")
    public int code;

    @Column(name = "status")
    public String status;

    @Column(name = "time")
    public Date time;

    @Column(name = "contract_number")
    public int contract_number;
}
