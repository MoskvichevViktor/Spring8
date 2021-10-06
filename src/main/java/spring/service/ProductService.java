package spring.service;

import spring.dao.ProductDAO;
import spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductDAO dao;

    public void saveOrUpdate(Product product){
        dao.saveOrUpdate(product);
    }

    public Product findById(long id){
        return dao.findById(id);
    }

    public Page<Product> findAll(int pageSize, int pageNum){

        return dao.findAll(pageSize, pageNum);
    }

    public void deleteById(long id){
        dao.deleteById(id);
    }

    public Page<Product> getFiltered(String filter, int size, int num){
        Page<Product> page;
        switch (filter){
            case "cheap": page = dao.findMostCheap(); break;
            case "expensive": page = dao.findMostExpensive(); break;
            case "both": page = dao.findMostCheapAndExpensive(); break;
            default: page = findAll(size, num); break;
        }
        return page;
    }
}
