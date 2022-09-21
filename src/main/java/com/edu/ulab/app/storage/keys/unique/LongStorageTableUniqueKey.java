package com.edu.ulab.app.storage.keys.unique;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LongStorageTableUniqueKey extends StorageTableUniqueKey<Long> {

    @Override
    public Long getNextValue() {
        Long value = this.getValue();
        this.setValue(++value);
        return value;
    }

}
