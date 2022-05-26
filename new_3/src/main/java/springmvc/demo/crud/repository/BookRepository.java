package springmvc.demo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springmvc.demo.crud.entity.Book;
import springmvc.demo.crud.entity.Category;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	@Query("select b from Book b where b.author like %:keyword% or b.name like %:keyword% or b.bookDetails.isbn like %:keyword%")
	public List<Book> findByCri(@Param("keyword") String keyword);
}
