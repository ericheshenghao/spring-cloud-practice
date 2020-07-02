package com.springcloud.repository;

import com.springcloud.repository.jpa.StorageDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageJpaRepository extends JpaRepository<StorageDo,Long>, QuerydslPredicateExecutor<StorageDo> {

}
