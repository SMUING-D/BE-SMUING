package dev.umc.smuing.mapping;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProject.StudyProject;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user_study_project")
public class UserStudyProject extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_study_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_id")
    private StudyProject studyProject;
}
