package com.springcloud.repository.jpa;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderDo is a Querydsl query type for OrderDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderDo extends EntityPathBase<OrderDo> {

    private static final long serialVersionUID = 881129621L;

    public static final QOrderDo orderDo = new QOrderDo("orderDo");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigDecimal> money = createNumber("money", java.math.BigDecimal.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QOrderDo(String variable) {
        super(OrderDo.class, forVariable(variable));
    }

    public QOrderDo(Path<? extends OrderDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderDo(PathMetadata metadata) {
        super(OrderDo.class, metadata);
    }

}

