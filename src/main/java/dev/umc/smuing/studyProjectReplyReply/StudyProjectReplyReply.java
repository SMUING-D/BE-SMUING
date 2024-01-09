package dev.umc.smuing.studyProjectReplyReply;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProject.StudyProject;
import dev.umc.smuing.studyProjectReply.StudyProjectReply;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "study_project_reply_reply")
public class StudyProjectReplyReply extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_reply_reply_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_id")
    private StudyProject studyProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_reply_id")
    private StudyProjectReply studyProjectReply;
}
