package com.iss.pafassessment01.repositories;

public class Queries {

    public static final String SQL_INSERT_ACCOUNTS_TABLE = """
        insert into accounts(account_id, name,  
        balance) values 
        ( ?, ? ,?)
        """;

    public static final String SQL_FIND_ACCOUNTS_NAMECONCATID = """
        SELECT CONCAT(`name`, ' ', '(', account_id, ')') FROM accounts;
        """;
    
}
