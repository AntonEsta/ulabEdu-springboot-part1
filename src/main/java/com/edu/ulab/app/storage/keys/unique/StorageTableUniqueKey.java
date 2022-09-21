package com.edu.ulab.app.storage.keys.unique;

import lombok.Data;

@Data
public abstract class StorageTableUniqueKey<T> {

    private T value;

    public abstract T getNextValue();

}
