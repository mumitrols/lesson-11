package ru.netology.domain;

import ru.netology.repo.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }
    public void add(Product product){
        this.repo.save(product);
    }
    public Product[] searchBy(String text) {
        Product[] products = this.repo.findAll();
        Product[] result = new Product[0];
        for(Product product : products){
            if(matches(product, text)){
                Product[] temp = new Product[result.length + 1];
                System.arraycopy(result, 0, temp, 0, result.length);
                temp[temp.length - 1] = product;
                result = temp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if(product.getName().contains((search))){
            return true;
        };
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if(product instanceof Smartphone){
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
