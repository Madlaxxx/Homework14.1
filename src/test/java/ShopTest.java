import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netolgy.NotFoundException;
import ru.netolgy.Product;
import ru.netolgy.ShopRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopTest {

    Product product1 = new Product(555, "Футболка", 3_500);
    Product product2 = new Product(456, "Брюки", 8_000);
    Product product3 = new Product(121, "Галстук", 1_700);

    @Test
    public void removeByIdNotException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(456);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(454);
        });

    }
}
