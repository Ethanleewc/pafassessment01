package com.iss.pafassessment01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.iss.pafassessment01.models.Transaction;

@Qualifier("logAuditService")
@Service
public class LogAuditService {

    private static final String TRANSACTION_ENTITY = "transactionlist";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void save(final Transaction trans){
        redisTemplate.opsForList()
            .leftPush(TRANSACTION_ENTITY, trans.getTransactionId());
        redisTemplate.opsForHash()
            .put( TRANSACTION_ENTITY + "_Map", trans.getTransactionId(), trans);
    }
    
}
