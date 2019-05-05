package org.thibaut.thelibrary.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEditor is a Querydsl query type for Editor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEditor extends EntityPathBase<Editor> {

    private static final long serialVersionUID = -1818935123L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEditor editor = new QEditor("editor");

    public final ListPath<Book, QBook> books = this.<Book, QBook>createList("books", Book.class, QBook.class, PathInits.DIRECT2);

    public final QCoordinates coordinates;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QEditor(String variable) {
        this(Editor.class, forVariable(variable), INITS);
    }

    public QEditor(Path<? extends Editor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEditor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEditor(PathMetadata metadata, PathInits inits) {
        this(Editor.class, metadata, inits);
    }

    public QEditor(Class<? extends Editor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new QCoordinates(forProperty("coordinates"), inits.get("coordinates")) : null;
    }

}

