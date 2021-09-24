package spring.repository;

import spring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {

    Product save(Product p);

    Optional<Product> findById(Long id);

    Page<Product> findAll(Pageable pageable);

    void deleteById(Long aLong);

    @Query(value = "select min(price) from #{#entityName}", nativeQuery = true)
    int findMinPrice();

    @Query(value = "select max(price) from #{#entityName}", nativeQuery = true)
    int findMaxPrice();

    @Query(value = "select * from #{#entityName} " +
            "where price = (select min(price) from #{#entityName}) limit 1", nativeQuery = true)
    Page<Product> getWithMinPrice(Pageable pageable);

    @Query(value = "select * from #{#entityName} " +
            "where price = (select max(price) from #{#entityName}) limit 1", nativeQuery = true)
    Page<Product> getWithMaxPrice(Pageable pageable);

}
