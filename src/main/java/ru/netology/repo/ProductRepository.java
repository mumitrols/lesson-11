package ru.netology.repo;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] temp = new Product[items.length + 1];
        System.arraycopy(items, 0, temp, 0, items.length);
        temp[temp.length - 1] = item;
        this.items = temp;
    }

    public Product[] findAll() {
        return this.items;
    }

    public Product findById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(long id) {
        Product[] temp = new Product[items.length - 1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                temp[index] = item;
                index++;
            }
            if (findById(id) == null) {
                return;
            }
        }
        items = temp;
    }
}
