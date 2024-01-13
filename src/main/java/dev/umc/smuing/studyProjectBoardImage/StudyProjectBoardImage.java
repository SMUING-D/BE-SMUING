package dev.umc.smuing.studyProjectBoardImage;

import dev.umc.smuing.studyProjectBoard.StudyProjectBoard;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "study_project_board_Image")
public class StudyProjectBoardImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_board_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_board_id")
    private StudyProjectBoard studyProjectBoard;

    @Column(name = "study_project_board_image_path")
    private String studyProjectBoardImagePath;
}
