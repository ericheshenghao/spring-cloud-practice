package com.springcloud.adapter.repository.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentDo is a Querydsl query type for PaymentDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentDo extends EntityPathBase<PaymentDo> {

    private static final long serialVersionUID = -323034005L;

    public static final QPaymentDo paymentDo = new QPaymentDo("paymentDo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath serial = createString("serial");

    public QPaymentDo(String variable) {
        super(PaymentDo.class, forVariable(variable));
    }

    public QPaymentDo(Path<? extends PaymentDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentDo(PathMetadata metadata) {
        super(PaymentDo.class, metadata);
    }

}

