package dev.umc.smuing.mapping;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProjectBoard.StudyProjectBoard;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_study_project")
public class UserStudyProject extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_study_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_board_id")
    private StudyProjectBoard studyProjectBoard;
}
