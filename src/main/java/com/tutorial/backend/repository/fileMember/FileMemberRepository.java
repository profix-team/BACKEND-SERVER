package com.tutorial.backend.repository.fileMember;

import com.tutorial.backend.entity.FileMember;
import com.tutorial.backend.entity.FileMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMemberRepository  extends JpaRepository<FileMember, FileMemberId>, FileMemberQueryDSL {
}
