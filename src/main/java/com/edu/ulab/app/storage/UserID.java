package com.edu.ulab.app.storage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@EqualsAndHashCode
public class UserID {
    @Getter
    @Setter
    private final UUID ID;

    public UserID() {
        this.ID = UUID.randomUUID();
    }

    public UserID(UUID id) {
        this.ID = id;
    }

}
