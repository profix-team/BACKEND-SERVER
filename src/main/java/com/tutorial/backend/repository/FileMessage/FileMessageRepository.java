package com.tutorial.backend.repository.FileMessage;

import com.tutorial.backend.entity.FileMessage;
import com.tutorial.backend.entity.FileMessageId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileMessageRepository extends JpaRepository<FileMessage, FileMessageId>, FileMessageQueryDSL {
    List<FileMessage> findByMessageId(String messageId);
}
