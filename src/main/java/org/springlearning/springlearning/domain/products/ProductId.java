package org.springlearning.springlearning.domain.products;

import org.springframework.util.Assert;

import java.util.UUID;

public record BookId(UUID bookId) {
    public BookId {
        Assert.notNull(bookId, "BookId should not be null!");
    }
    public BookId()  {
        this(UUID.randomUUID());
    }
}
