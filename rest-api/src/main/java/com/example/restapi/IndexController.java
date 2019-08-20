package com.example.restapi;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

@RestController
public class IndexController {


    private final CodeRep coderep;
    private final TranRep tranrep;

    @Autowired
    public IndexController(CodeRep coderep, TranRep tranrep) {
        this.coderep = coderep;
        this.tranrep = tranrep;
    }

    @PostMapping(value = "/newStatus", consumes = "application/json", produces = "application/json")
    public Transaction newStatus(@RequestBody Transaction status) {
        if (!coderep.existsBycode(status.code)) {
            Code code = new Code();
            code.code=status.code;
            coderep.save(code);
            if (tranrep.findBycodeAndstatus(status.code, status.status).isPresent()) {
                tranrep.findBycodeAndstatus(status.code, status.status).get().time=new Date();
                return status;
            }
        }
        status.time=new Date();
        return tranrep.save(status);
    }

    @GetMapping("/showStatuses")
    public Iterable<Transaction> allStatuses(@RequestBody Iterable i) {
        return tranrep.findAllById(i);
    }

}
