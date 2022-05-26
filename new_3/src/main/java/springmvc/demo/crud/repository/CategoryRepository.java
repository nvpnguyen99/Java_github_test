package springmvc.demo.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springmvc.demo.crud.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
