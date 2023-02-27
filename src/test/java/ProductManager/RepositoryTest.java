package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testRemoveWenProductExist() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWenProductNotExist() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddAllProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Smartphone smartphone1 = new Smartphone(1, "S23", 60_000, "Samsung");
        Product product1 = new Product(1, "Хлеб", 50);

        repo.add(book1);
        repo.add(smartphone1);
        repo.add(product1);


        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, product1};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddNotProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Smartphone smartphone1 = new Smartphone(1, "S23", 60_000, "Samsung");
        Product product1 = new Product(1, "Хлеб", 50);

        repo.add(smartphone1);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

}