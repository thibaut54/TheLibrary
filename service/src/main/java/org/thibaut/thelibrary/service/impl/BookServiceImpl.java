package org.thibaut.thelibrary.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.*;
import org.thibaut.thelibrary.service.contract.BookService;

import java.util.Collections;
import java.util.List;

@Component
public class BookServiceImpl extends AbstractService implements BookService {

	@Override
	public String getBookTitle( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get().getTitle();
	}

	@Override
	public Book getBookById( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get();
	}


	public List<Book> getBookByTitle( String title, String authorLastName, String authorFirstName, String style){

		List< Author > authors = getRepositoryFactory().getAuthorRepository().getAuthorsByLastNameAndFirstName( authorLastName,  authorFirstName  );

//		return getRepositoryFactory().getBookRepository().getBooksByTitleContainsAndAuthorsContainsAndStylesContains( title,  authors,  );
		return null;
	}


	public Page findBookByTitleAndAuthorAndCategory( Pageable pageable, String bookTitle, List<String> authorsNames, List<String> categories ){

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		QBook qBook = QBook.book;
		QAuthor qAuthor = QAuthor.author;
		QCategory qCategory = QCategory.category1;

		QAtlas qAtlas = QAtlas.atlas;
		QArea qArea = QArea.area;
		QCrag qCrag = QCrag.crag;
		QRoute qRoute = QRoute.route;

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		JPAQueryFactory queryFactory = new JPAQueryFactory( getEm() );


		List< ? > result = null;

		/*
		1 - extract the list of books that contains the requested title
		2 - filter by author names' list
		3 - filter by categories' list
		*/

		if( ! bookTitle.equals( "" )){

			booleanBuilder.and( qBook.title.containsIgnoreCase(bookTitle));

		}

		if( ! authorsNames.isEmpty() ){
			for ( Author author: authorsNames ) {

			}
			booleanBuilder.and( qAtlas.country.containsIgnoreCase(country) );
		}


		JPAQuery< ? > query = queryFactory.from(qAtlas);

		if(category .equals( "Atlas" )){
			if( ! city.equals( "" )){
				query.innerJoin( qAtlas.areas, qArea );
			}
			result = query.where(booleanBuilder)
					         .select(qAtlas)
					         .fetch();
		}
		else if (category .equals( "Area" )){
			result = query.innerJoin(qAtlas.areas, qArea)
					         .where(booleanBuilder)
					         .select(qArea)
					         .fetch();
		}
		else if (category .equals( "Crag" )){
			result = query.innerJoin(qAtlas.areas, qArea)
					         .innerJoin(qArea.crags, qCrag)
					         .where(booleanBuilder)
					         .select(qCrag)
					         .fetch();
		}
		else if (category .equals( "Route" )){
			result = query.innerJoin( qAtlas.areas, qArea )
					         .innerJoin(qArea.crags, qCrag)
					         .innerJoin( qCrag.routes, qRoute  )
					         .where(booleanBuilder)
					         .select(qRoute)
					         .fetch();
		}

		List<?> list;

		if (result.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, result.size());
			list = result.subList(startItem, toIndex);
		}

		return new PageImpl(list, PageRequest.of( currentPage, pageSize ), (long)result.size() );
	}
}
