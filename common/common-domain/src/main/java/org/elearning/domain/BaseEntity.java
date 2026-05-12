package org.elearning.domain;

import java.util.Objects;

public abstract class BaseEntity<ID> {
    private ID id;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseEntity<?> that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
