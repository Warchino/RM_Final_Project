/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 * <p>
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.seedstack.samples.store.domain.model.customer;

import org.seedstack.business.domain.BaseAggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Class Customer.
 */
@Entity
public class Customer extends BaseAggregateRoot<CustomerId> {
    @EmbeddedId
    private CustomerId id;
    private String firstName;
    private String lastName;
    private String address;
    private String deliveryAddress;
    private String password;

    /**
     * Customer Constructor.
     */
    private Customer() {
        // A default constructor is needed by the persistence framework
        // but can be kept private
    }

    /**
     * Customer with id.
     *
     * @param customerId Object.
     */
    public Customer(final CustomerId customerId) {
        this.id = customerId;
    }

    /**
     * Getter.
     *
     * @return Object.
     */
    @Override
    public CustomerId getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter.
     *
     * @param firstName String.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter.
     *
     * @param lastName String.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter.
     *
     * @param address String.
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Setter.
     *
     * @param deliveryAddress String.
     */
    public void setDeliveryAddress(final String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Getter.
     *
     * @return String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter.
     *
     * @param password String.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
}
