package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

       @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchWhenOneProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Harry Potter2");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchWhenNotProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Harry Potter", 100, "Rolling");
        Book book2 = new Book(2, "War and Piece", 200, "Tolstoy");
        Book book3 = new Book(3, "Harry Potter2", 300, "Rolling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Testing Dot Com");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}