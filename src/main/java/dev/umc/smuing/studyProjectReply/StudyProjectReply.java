package dev.umc.smuing.studyProjectReply;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProjectReplyReply.StudyProjectReplyReply;
import dev.umc.smuing.studyProject.StudyProject;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_project_reply")
@Getter
public class StudyProjectReply extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_reply_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_id")
    private StudyProject studyProject;

    @OneToMany(mappedBy = "studyProjectReply")
    private List<StudyProjectReplyReply> studyProjectReplyReplies = new ArrayList<>();

}
