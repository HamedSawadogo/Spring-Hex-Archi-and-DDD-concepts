package org.springlearning.springlearning.domain;

import org.springframework.util.Assert;
import java.util.UUID;

public record AccountId(String id) {
    public AccountId {
        Assert.notNull(id, "account ID is require");
    }

    public static AccountId create() {
        return new AccountId(UUID.randomUUID().toString());
    }
}
