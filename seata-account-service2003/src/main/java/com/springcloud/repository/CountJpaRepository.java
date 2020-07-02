package com.springcloud.repository;

import com.springcloud.repository.jpa.CountDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountJpaRepository extends JpaRepository<CountDo,Long>, QuerydslPredicateExecutor<CountDo> {

}
