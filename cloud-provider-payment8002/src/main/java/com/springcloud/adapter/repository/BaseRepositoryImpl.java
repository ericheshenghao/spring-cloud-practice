package com.springcloud.adapter.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract public class BaseRepositoryImpl {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected JPAQueryFactory jpaQueryFactory;


}
