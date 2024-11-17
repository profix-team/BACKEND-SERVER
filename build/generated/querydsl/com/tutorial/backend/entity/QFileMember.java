package com.tutorial.backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFileMember is a Querydsl query type for FileMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFileMember extends EntityPathBase<FileMember> {

    private static final long serialVersionUID = -1259265436L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFileMember fileMember = new QFileMember("fileMember");

    public final QFile file;

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFileMember(String variable) {
        this(FileMember.class, forVariable(variable), INITS);
    }

    public QFileMember(Path<? extends FileMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFileMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFileMember(PathMetadata metadata, PathInits inits) {
        this(FileMember.class, metadata, inits);
    }

    public QFileMember(Class<? extends FileMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.file = inits.isInitialized("file") ? new QFile(forProperty("file")) : null;
    }

}

