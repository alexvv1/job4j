package ru.vorotov.genericpro.GenericStore;

import java.util.Objects;

/**
 * Базовый класс модели.
 */
public abstract class BaseModel {

    /**
     * Идентификатор.
     */
    private final String id;

    /**
     * Конструктор.
     * @param id Идентификатор.
     */
    BaseModel(final String id) {
        this.id = id;
    }

    /**
     * Идентификатор.
     * @return Идентификатор.
     */
    public String getId() {
        return id;
    }

    /**
     *  Indicates whether some other object is "equal to" this one.
     *
     * @param   obj   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseModel baseModel = (BaseModel) obj;
        return Objects.equals(id, baseModel.id);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     *
     * @return {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
