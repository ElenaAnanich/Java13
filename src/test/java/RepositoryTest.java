import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testRemoveProduct() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Бешеные деньги", 1000, "Островский");
        Book book2 = new Book(2, "<Бесы>", 2000, "Достоевский");
        Book book3 = new Book(3, "Преступление и Наказание", 3000, "Достоевский");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeID(1);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testAdd() {
        Repository repo = new Repository();

        ProductManager manager = new ProductManager(repo);

        Book book1 = new Book(1, "Бешеные деньги", 1000, "Островский");
        Book book2 = new Book(2, "<Бесы>", 2000, "Достоевский");
        Book book3 = new Book(3, "Преступление и Наказание", 3000, "Достоевский");

        repo.add(book1);
        repo.add(book2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(actual, expected);

    }
}