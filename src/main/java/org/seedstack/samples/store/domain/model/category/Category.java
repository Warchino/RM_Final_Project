/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 * <p>
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.seedstack.samples.store.domain.model.category;

import org.seedstack.business.domain.BaseAggregateRoot;
import org.seedstack.business.domain.Identity;
import org.seedstack.business.util.inmemory.InMemorySequenceGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class Category.
 */
@Entity
public class Category extends BaseAggregateRoot<Long> {
    @Id
    @Identity(generator = InMemorySequenceGenerator.class)
    private Long id;
    private String name;
    private String urlImg;

    /**
     * Empty constructor.
     */
    Category() {
        // A private constructor ensures that the category is created through its
        // factory so the identity generator is invoked just after creation
    }

    /**
     * Getter.
     *
     * @return Long.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name String.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     * Setter.
     *
     * @param urlImg String.
     */
    public void setUrlImg(final String urlImg) {
        this.urlImg = urlImg;
    }
}
