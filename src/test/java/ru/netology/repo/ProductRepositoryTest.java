package ru.netology.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private final Product firstProduct = new Product(1, "Блуза_ice", 1500);
    private final Product secondProduct = new Product(2, "Брюки_размер_7", 500);
    private final Book firstBook = new Book(3, "Шьем_брюки_7_урок", 101, "Иванов");
    private final Book secondBook = new Book(4, "Дела_не_ice", 500, "Петров");
    private final Smartphone firstSmartphone = new Smartphone(5, "Note_ice", 24000, "Samsung");
    private final Smartphone secondSmartphone = new Smartphone(6, "Vito_7", 40000, "Samsung");


    @BeforeEach
    void setDataProducts() {
        repository.save(firstProduct);
        repository.save(secondProduct);
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);

    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        Product[] expected = {firstProduct, secondProduct, firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(3);
        Product[] expected = {firstProduct, secondProduct, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNonExistentId() {
        repository.removeById(1000);
        Product[] expected = {firstProduct, secondProduct, firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveAllProducts() {
        Product[] expected = {firstProduct, secondProduct, firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void checkSetAuthorBook() {
        firstBook.setAuthor("Новый автор");
        assertEquals("Новый автор", firstBook.getAuthor());

    }

    @Test
    void checkSetIdBook() {
        firstBook.setId(100);
        assertEquals(100, firstBook.getId());

    }

    @Test
    void checkSetIdSmartphone() {
        firstSmartphone.setId(200);
        assertEquals(200, firstSmartphone.getId());
    }

    @Test
    void checkSetManufacturerSmartphone() {
        firstSmartphone.setManufacturer("Производитель");
        assertEquals("Производитель", firstSmartphone.getManufacturer());
    }

    @Test
    void checkSetNameSmartphone() {
        firstSmartphone.setName("Новый_Смартфон");
        assertEquals("Новый_Смартфон", firstSmartphone.getName());
    }
    @Test
    void checkSetPriceSmartphone() {
        firstSmartphone.setPrice(100);
        assertEquals(100, firstSmartphone.getPrice());
    }

}