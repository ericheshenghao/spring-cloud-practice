package com.springcloud.repository.jpa;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCountDo is a Querydsl query type for CountDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCountDo extends EntityPathBase<CountDo> {

    private static final long serialVersionUID = -1248897514L;

    public static final QCountDo countDo = new QCountDo("countDo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigDecimal> residue = createNumber("residue", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> used = createNumber("used", java.math.BigDecimal.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QCountDo(String variable) {
        super(CountDo.class, forVariable(variable));
    }

    public QCountDo(Path<? extends CountDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountDo(PathMetadata metadata) {
        super(CountDo.class, metadata);
    }

}

