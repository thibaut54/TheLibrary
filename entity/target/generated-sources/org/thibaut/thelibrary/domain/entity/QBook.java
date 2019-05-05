package org.thibaut.thelibrary.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = -1275712983L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final ListPath<Author, QAuthor> authors = this.<Author, QAuthor>createList("authors", Author.class, QAuthor.class, PathInits.DIRECT2);

    public final ListPath<Category, QCategory> categories = this.<Category, QCategory>createList("categories", Category.class, QCategory.class, PathInits.DIRECT2);

    public final QEditor editor;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isbn = createNumber("isbn", Integer.class);

    public final StringPath language = createString("language");

    public final ListPath<Library, QLibrary> libraries = this.<Library, QLibrary>createList("libraries", Library.class, QLibrary.class, PathInits.DIRECT2);

    public final ListPath<Loan, QLoan> loans = this.<Loan, QLoan>createList("loans", Loan.class, QLoan.class, PathInits.DIRECT2);

    public final NumberPath<Integer> numberOfPages = createNumber("numberOfPages", Integer.class);

    public final DatePath<java.time.LocalDate> publicationDate = createDate("publicationDate", java.time.LocalDate.class);

    public final StringPath title = createString("title");

    public QBook(String variable) {
        this(Book.class, forVariable(variable), INITS);
    }

    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.editor = inits.isInitialized("editor") ? new QEditor(forProperty("editor"), inits.get("editor")) : null;
    }

}

