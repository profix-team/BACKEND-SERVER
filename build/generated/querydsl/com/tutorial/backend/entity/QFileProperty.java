package com.tutorial.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFileProperty is a Querydsl query type for FileProperty
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileProperty extends EntityPathBase<FileProperty> {

    private static final long serialVersionUID = 682994463L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFileProperty fileProperty = new QFileProperty("fileProperty");

    public final QFile file;

    public final NumberPath<Long> propertyId = createNumber("propertyId", Long.class);

    public QFileProperty(String variable) {
        this(FileProperty.class, forVariable(variable), INITS);
    }

    public QFileProperty(Path<? extends FileProperty> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFileProperty(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFileProperty(PathMetadata metadata, PathInits inits) {
        this(FileProperty.class, metadata, inits);
    }

    public QFileProperty(Class<? extends FileProperty> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.file = inits.isInitialized("file") ? new QFile(forProperty("file")) : null;
    }

}

