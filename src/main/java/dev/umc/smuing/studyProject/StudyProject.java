package dev.umc.smuing.studyProject;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProjectReply.StudyProjectReply;
import dev.umc.smuing.studyProjectReplyReply.StudyProjectReplyReply;
import dev.umc.smuing.mapping.UserStudyProject;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "study_project")
public class StudyProject extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_id")
    private Long id;

    private String title;

    private String content;

    @Column(name = "state_date")
    private LocalDateTime startDate;

    @Column(name = "person_num")
    private LocalDateTime personNum;

    @Enumerated(EnumType.STRING)
    private StudyProjectType type;

    private LocalDateTime deadline;

    @OneToMany(mappedBy = "studyProject")
    private List<UserStudyProject> userStudyProjects = new ArrayList<>();

    @OneToMany(mappedBy = "studyProject")
    private List<StudyProjectReply> studyProjectReplies = new ArrayList<>();

    @OneToMany(mappedBy = "studyProject")
    private List<StudyProjectReplyReply> studyProjectReplyReplies = new ArrayList<>();
}
