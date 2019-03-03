package org.seedstack.samples.store.domain.model.category;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
        category.setName("pepe");
        category.setUrlImg("url");
    }

    @Test
    public void getId() {
        assertNull(category.getId());
    }

    @Test
    public void getName() {
        assertEquals("pepe", category.getName());
    }

    @Test
    public void setName() {
        category.setName("x");
        assertEquals("x", category.getName());
    }

    @Test
    public void getUrlImg() {
        assertEquals("url", category.getUrlImg());
    }

    @Test
    public void setUrlImg() {
        category.setUrlImg("1");
        assertEquals("1", category.getUrlImg());
    }
}
