package com.tutorial.backend.service.fileMember;

import com.tutorial.backend.entity.File;
import com.tutorial.backend.entity.FileMember;
import com.tutorial.backend.entity.Member;
import com.tutorial.backend.repository.fileMember.FileMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FileMemberService {

    private final FileMemberRepository fileMemberRepository;

    public void saveFileMember(File file, Member member) {
        FileMember fileMember = FileMember.builder()
                .file(file)
                .memberId(member.getId())
                .build();

        fileMemberRepository.save(fileMember);
    }
}
