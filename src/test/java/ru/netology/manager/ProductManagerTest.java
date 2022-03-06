package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final Product firstProduct = new Product(1,"Блуза_ice",1500);
    private final Product secondProduct = new Product(2, "Брюки_размер_7", 500);
    private final Book firstBook = new Book(3,"Шьем_брюки_7_урок",108, "Иванов");
    private final Book secondBook = new Book(4,"Шьем_брюки_не_ice",500, "Петров");
    private final Smartphone firstSmartphone = new Smartphone(5, "Note_ice", 24000, "Samsung");
    private final Smartphone secondSmartphone = new Smartphone(6, "Vito_7", 40000, "Samsung");

    private final ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void searchBy() {
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    void searchByExistingText(){
        Product[] expected = {firstProduct, secondBook, firstSmartphone};
        Product[] actual = manager.searchBy("ice");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNoExistingText(){
        Product[] expected = {};
        Product[] actual = manager.searchBy("хлеб");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOverlapInNameBooks(){
        Product[] expected = {firstBook, secondBook,};
        Product[] actual = manager.searchBy("Шьем_брюки");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOverlapInAuthorBooks(){
        Product[] expected = {firstBook};
        Product[] actual = manager.searchBy("Иванов");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOverlapInManufacturerSmartphones(){
        Product[] expected = { firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }
}