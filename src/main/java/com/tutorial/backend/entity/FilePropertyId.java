package com.tutorial.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class FilePropertyId  implements Serializable {
    private Long file;
    private String propertyId; // Long에서 String으로 변경

    // Default constructor
    public FilePropertyId() {
    }

    // Constructor with parameters
    public FilePropertyId(Long file, String propertyId) {
        this.file = file;
        this.propertyId = propertyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilePropertyId that = (FilePropertyId) o;
        return file == that.file && Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, propertyId);
    }

}