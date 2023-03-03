package com.iss.pafassessment01.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iss.pafassessment01.models.Account;

import static com.iss.pafassessment01.repositories.Queries.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountsRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Account> findNameWithId(){
        List<Account> resultList = new ArrayList<Account>();
        resultList = template.query(SQL_FIND_ACCOUNTS_NAMECONCATID, BeanPropertyRowMapper.newInstance(Account.class));
        return resultList;
    }

    public boolean updateAcc(Account acc, String transId) {
        return template.update(SQL_INSERT_ACCOUNTS_TABLE, 
                 acc.getAccountId(),
                 acc.getName(), 
                 acc.getBalance()) > 0;
    }
    
}
