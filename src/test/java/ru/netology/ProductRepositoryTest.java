package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product book = new Book(8, "Евгений Онегин", 660, "А.С.Пушкин");
    Product smartphone1 = new Smartphone(6, "Phone Honor", 30_000, "China");
    Product smartphone2 = new Smartphone(2, "Phone Samsung", 60_000, "South Korea");
    Product product = new Product(11, "Книга", 500);

    @BeforeEach
    public void addProducts() {
        repo.save(book);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(product);
    }
    @Test
    public void removeById() {
        repo.removeById(11);

        Product[] expected = {book, smartphone1, smartphone2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void negative() {

        Assertions.assertThrows(NotFoundException.class,()->{
            repo.removeById(1);
        });
    }
}