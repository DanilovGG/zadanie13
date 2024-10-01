import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Яблоко", 100);
        Product product2 = new Product(2, "Банан", 200);

        repo.add(product1);
        repo.add(product2);
        repo.remove(2);

        Product[] action = repo.findAll();
        Product[] expected = {product1};
        assertArrayEquals(expected, action);
    }

    @Test
    public void testRemoveNoProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Яблоко", 100);
        Product product2 = new Product(2, "Банан", 200);

        repo.add(product1);
        repo.add(product2);

        assertThrows(
                NotFoundException.class,
                () -> repo.remove(3)
        );
    }

    @Test
    void testHashCodeUniqueness() {
        Product apple = new Product(1, "Яблоко", 100);
        Product banana = new Product(2, "Банан", 200);

        assertNotEquals(apple.hashCode(), banana.hashCode());
    }
}