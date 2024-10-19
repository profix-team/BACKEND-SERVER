package com.tutorial.backend.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "tbl_file_property")
@IdClass(FilePropertyId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FileProperty {
    @Id
    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private File file;

    @Id
    private Long propertyId;

    @Builder
    public FileProperty(File file, Long propertyId) {
        this.file = file;
        this.propertyId = propertyId;
    }
}
