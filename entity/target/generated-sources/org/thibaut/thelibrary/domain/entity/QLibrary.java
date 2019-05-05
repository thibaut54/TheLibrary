package org.thibaut.thelibrary.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLibrary is a Querydsl query type for Library
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLibrary extends EntityPathBase<Library> {

    private static final long serialVersionUID = 1501752699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLibrary library = new QLibrary("library");

    public final ListPath<Book, QBook> books = this.<Book, QBook>createList("books", Book.class, QBook.class, PathInits.DIRECT2);

    public final QCoordinates coordinates;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QLibrary(String variable) {
        this(Library.class, forVariable(variable), INITS);
    }

    public QLibrary(Path<? extends Library> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLibrary(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLibrary(PathMetadata metadata, PathInits inits) {
        this(Library.class, metadata, inits);
    }

    public QLibrary(Class<? extends Library> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new QCoordinates(forProperty("coordinates"), inits.get("coordinates")) : null;
    }

}

