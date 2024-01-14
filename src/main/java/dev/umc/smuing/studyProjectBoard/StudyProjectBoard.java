package dev.umc.smuing.studyProjectBoard;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.global.Enum.StudyProjectType;
import dev.umc.smuing.studyProjectBoardImage.StudyProjectBoardImage;
import dev.umc.smuing.studyProjectComment.StudyProjectComment;
import dev.umc.smuing.mapping.UserStudyProject;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "study_project_board")
public class StudyProjectBoard extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_board_id")
    private Long id;

    private String title;

    private String content;

    @Column(name = "state_date")
    private LocalDateTime startDate;

    @Column(name = "member_count")
    private LocalDateTime memberCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_project_type")
    private StudyProjectType studyProjectType;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    private String college;

    @OneToMany(mappedBy = "studyProjectBoard")
    private List<UserStudyProject> userStudyProjects = new ArrayList<>();

    @OneToMany(mappedBy = "studyProjectBoard")
    private List<StudyProjectComment> studyProjectComments = new ArrayList<>();

    @OneToMany(mappedBy = "studyProjectBoard")
    private List<StudyProjectBoardImage> studyProjectBoardImages = new ArrayList<>();
}
