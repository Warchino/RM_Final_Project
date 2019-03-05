package org.seedstack.samples.store.domain.model.category;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test Class.
 */
public class CategoryTest {

    private Category category;

    /**
     * Setup method.
     */
    @Before
    public void setUp() {
        category = new Category();
        category.setName("pepe");
        category.setUrlImg("url");
    }

    /**
     * Test Method.
     */
    @Test
    public void getId() {
        assertNull(category.getId());
    }

    /**
     * Test Method.
     */
    @Test
    public void getName() {
        assertEquals("pepe", category.getName());
    }

    /**
     * Test Method.
     */
    @Test
    public void setName() {
        category.setName("x");
        assertEquals("x", category.getName());
    }

    /**
     * Test Method.
     */
    @Test
    public void getUrlImg() {
        assertEquals("url", category.getUrlImg());
    }

    /**
     * Test Method.
     */
    @Test
    public void setUrlImg() {
        category.setUrlImg("1");
        assertEquals("1", category.getUrlImg());
    }
}
