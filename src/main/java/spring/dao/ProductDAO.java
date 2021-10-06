package spring.dao;

import spring.entity.Product;
import spring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {
    @Autowired
    private ProductRepo repo;

    public void saveOrUpdate(Product product){
        repo.save(product);
    }

    public Product findById(long id){
        return repo.findById(id).orElse(null);
    }

    public Page<Product> findAll(int pageSize, int pageNum){
        return repo.findAll(Pageable.ofSize(pageSize).withPage(pageNum));
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Page<Product> findMostCheap(){

        return repo.getWithMinPrice(Pageable.unpaged());
    }

    public Page<Product> findMostExpensive(){

        return repo.getWithMaxPrice(Pageable.unpaged());
    }

    public Page<Product> findMostCheapAndExpensive(){
        List<Product> res = repo.getWithMinPrice(Pageable.unpaged()).and(repo.getWithMaxPrice(Pageable.unpaged())).toList();
        return new PageImpl<>(res);
    }
}
