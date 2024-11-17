package com.tutorial.backend.entity;

import java.io.Serializable;
import java.util.Objects;

public class FileMemberId implements Serializable {
    private Long file;
    private Long memberId;

    public FileMemberId() {
    }

    public FileMemberId(Long file, Long memberId) {
        this.file = file;
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileMemberId that = (FileMemberId) o;
        return file == that.file && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, memberId);
    }
}