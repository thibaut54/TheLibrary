package org.thibaut.thelibrary.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCoordinates is a Querydsl query type for Coordinates
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCoordinates extends EntityPathBase<Coordinates> {

    private static final long serialVersionUID = 1864082107L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoordinates coordinates = new QCoordinates("coordinates");

    public final StringPath additionalInformation = createString("additionalInformation");

    public final StringPath city = createString("city");

    public final QEditor editor;

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QLibrary library;

    public final NumberPath<Integer> phone = createNumber("phone", Integer.class);

    public final NumberPath<Integer> postalCode = createNumber("postalCode", Integer.class);

    public final StringPath street = createString("street");

    public final StringPath streetNumber = createString("streetNumber");

    public final QUser user;

    public QCoordinates(String variable) {
        this(Coordinates.class, forVariable(variable), INITS);
    }

    public QCoordinates(Path<? extends Coordinates> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoordinates(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoordinates(PathMetadata metadata, PathInits inits) {
        this(Coordinates.class, metadata, inits);
    }

    public QCoordinates(Class<? extends Coordinates> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.editor = inits.isInitialized("editor") ? new QEditor(forProperty("editor"), inits.get("editor")) : null;
        this.library = inits.isInitialized("library") ? new QLibrary(forProperty("library"), inits.get("library")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

