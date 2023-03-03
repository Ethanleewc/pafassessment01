package com.iss.pafassessment01.controllers;


import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iss.pafassessment01.exception.TransferException;
import com.iss.pafassessment01.models.Transaction;
import com.iss.pafassessment01.services.FundsTransferService;
import com.iss.pafassessment01.services.LogAuditService;


@Controller
@RequestMapping(path="/")
public class FundsTransferController {

    private FundsTransferService fundSvc;
    private LogAuditService auditSvc;

    @PostMapping
    public String postTransfer(@RequestBody MultiValueMap<String, String> form, Model model){

        String fromName = form.getFirst("fromnamelist");
        String toName = form.getFirst("tonamelist");
        BigDecimal amount = new BigDecimal(form.getFirst("amount"));
        String comment = form.getFirst("comment");
        Transaction trans = new Transaction();
        trans.setFromAccount(fromName);
        trans.setToAccount(toName);
        trans.setAmount(amount);
        trans.setComments(comment);
        model.addAttribute("transaction", trans);
        if(fromName.equals(toName)){
            
        }
        return "index";
    }

    @PostMapping("/transfer")
    public String confirmTransfer(Model model) throws TransferException {
        Transaction trans = new Transaction();
        fundSvc.createTransaction(trans);
        model.addAttribute("amount", trans);
        model.addAttribute("fromaccount", trans);
        model.addAttribute("toaccount", trans);
        model.addAttribute("transactionid", trans);
        auditSvc.save(trans);
        return "result";
    }
    
}
