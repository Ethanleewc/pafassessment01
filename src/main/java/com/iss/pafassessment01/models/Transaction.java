package com.iss.pafassessment01.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Transaction {

    private String transactionId;

    private Date date;

    private String fromAccount;

    private String toAccount;

    @NotNull(message = "Transfer amount cannot be 0")
    @Positive(message = "Value must not be negative")
    @Min(value = 10, message = "Minimum transfer amount is $10")
    private BigDecimal amount;

    private String comments;

    private List<Account> account = new LinkedList<Account>();


    public Transaction() {
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
        .add("transactionid", this.getTransactionId())
        .add("date", (JsonValue) this.getDate())
        .add("from_account", this.getFromAccount())
        .add("to_account", this.getToAccount())
        .add("amount", this.getAmount())
        .add("comments", this.getComments())
        .build();
    }
    
}
