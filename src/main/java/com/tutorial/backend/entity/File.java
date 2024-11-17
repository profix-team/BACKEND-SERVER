package com.tutorial.backend.entity;
import com.tutorial.backend.aduit.Period;
import com.tutorial.backend.entity.type.StatusType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "tbl_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
public class File extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String filePath;

    private String fileType;

    private String fileOriginName;

    private int fileSize;

    @Enumerated(EnumType.STRING)
    private StatusType fileIsDistorted;

    private String status;

    @OneToMany(mappedBy = "file")
    private List<FileMessage> fileMessages;

    @Builder

    public File(Long id, String uuid, String filePath, String fileType, String fileOriginName, int fileSize, StatusType fileIsDistorted, String status, List<FileMessage> fileMessages) {
        this.id = id;
        this.uuid = uuid;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileOriginName = fileOriginName;
        this.fileSize = fileSize;
        this.fileIsDistorted = fileIsDistorted;
        this.status = status;
        this.fileMessages = fileMessages;
    }
}
