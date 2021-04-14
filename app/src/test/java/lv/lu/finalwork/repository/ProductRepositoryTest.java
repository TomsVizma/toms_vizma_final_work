package lv.lu.finalwork.repository;

import lv.lu.finalwork.model.Product;
import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    private Map<Long, Product> repoMock;
    private ProductRepository victim;

    @Before
    public void setUp() throws Exception {
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
    }

    @Test
    public void shouldFindAllProducts() {
        Product orange = new Product();
        orange.setId(1L);
        Product fish = new Product();
        fish.setId(2L);

        repoMock.put(1L, orange);
        repoMock.put(2L, fish);

        List<Product> result = victim.findAll();
        assertNotNull(result);
        assertTrue(result.contains(orange));
        assertTrue(result.contains(fish));
    }

    @Test
    public void shouldFindProductById() {
        Product orange = new Product();
        repoMock.put(1L, orange);
        Product result = victim.findById(1L);
        assertEquals(result, orange);
    }

    @Test
    public void shouldProductSave() {
        Product orange = new Product();
        Long productId = victim.save(orange);
        assertEquals(productId, orange.getId());
        assertTrue(repoMock.containsKey(productId));
        assertEquals(orange, repoMock.get(productId));
    }

    @Test
    public void shouldRemoveProductsById() {
        Product orange = new Product();
        orange.setId(1L);
        repoMock.put(1L, orange);

    }

  }