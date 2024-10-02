import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(2, "Банан", 200);

        repo.add(p1);
        repo.add(p2);
        repo.remove(2);

        Product[] action = repo.findAll();
        Product[] expected = {p1};
        assertArrayEquals(expected, action);
    }

    @Test
    public void testRemoveNoProduct() {
        ShopRepository repo = new ShopRepository();
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(2, "Банан", 200);

        repo.add(p1);
        repo.add(p2);

        assertThrows(
                NotFoundException.class,
                () -> repo.remove(3)
        );
    }

    @Test
    void testHashCodeUniqueness() {
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(2, "Банан", 200);

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals_shouldReturnTrueForSameInstances() {
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(1, "Яблоко", 100);

        boolean result = p1.equals(p2);

        assertTrue(result);
    }

    @Test
    void testEquals_shouldReturnFalseForNull() {
        Product p1 = new Product(1, "Яблоко", 100);

        boolean result = p1.equals(null);

        assertFalse(result);
    }

    @Test
    void testEquals_shouldReturnTrueForIdenticalThis() {
        Product p1 = new Product(1, "Яблоко", 100);

        boolean result = p1.equals(p1);

        assertTrue(result);
    }

    @Test
    void testEquals_shouldReturnFalseForDifferentClasses() {
        Product p1 = new Product(1, "Яблоко", 100);
        Object o = new Object();

        boolean result = p1.equals(o);

        assertFalse(result);
    }

    @Test
    void testEquals_shouldReturnFalseForDifferentIds() {
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(2, "Яблоко", 99);

        boolean result = p1.equals(p2);

        assertFalse(result);
    }

    @Test
    void testEquals_shouldReturnFalseForDifferentTitles() {
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(1, "Банан", 100);

        boolean result = p1.equals(p2);

        assertFalse(result);
    }

    @Test
    void testEquals_shouldReturnFalseForDifferentPrices() {
        Product p1 = new Product(1, "Яблоко", 100);
        Product p2 = new Product(1, "Яблоко", 99);

        boolean result = p1.equals(p2);

        assertFalse(result);
    }
}