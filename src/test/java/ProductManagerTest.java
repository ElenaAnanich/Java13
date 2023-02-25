import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Бешеные деньги", 1000, "Островский");
        Book book2 = new Book(2, "<Бесы>", 2000, "Достоевский");
        Book book3 = new Book(3, "Преступление и Наказание", 3000, "Достоевский");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Бешеные деньги", 1000, "Островский");
        Book book2 = new Book(2, "<Бесы>", 2000, "Достоевский");
        Book book3 = new Book(3, "Преступление и Наказание", 3000, "Достоевский");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Бесы");
        Product[] expected = {book2};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findProduct2() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Бешеные деньги", 2000, "Островский");
        Book book2 = new Book(2, "<Преступление Бесы>", 2000, "Достоевский");
        Book book3 = new Book(3, "Преступление и Наказание", 3000, "Достоевский");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Преступление");
        Product[] expected = {book2, book3};


        Assertions.assertArrayEquals(actual, expected);
    }


}