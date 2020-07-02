package com.springcloud.repository.jpa;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStorageDo is a Querydsl query type for StorageDo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStorageDo extends EntityPathBase<StorageDo> {

    private static final long serialVersionUID = -1557068414L;

    public static final QStorageDo storageDo = new QStorageDo("storageDo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final NumberPath<Integer> residue = createNumber("residue", Integer.class);

    public final NumberPath<Integer> total = createNumber("total", Integer.class);

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public QStorageDo(String variable) {
        super(StorageDo.class, forVariable(variable));
    }

    public QStorageDo(Path<? extends StorageDo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStorageDo(PathMetadata metadata) {
        super(StorageDo.class, metadata);
    }

}

