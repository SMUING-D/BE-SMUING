package dev.umc.smuing.studyProjectComment;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProjectBoard.StudyProjectBoard;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_project_comment")
@Getter
public class StudyProjectComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_project_comment_id")
    private Long id;

    private String content;

    private Integer likes;

    private Integer reports;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private StudyProjectComment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<StudyProjectComment> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_project_board_id")
    private StudyProjectBoard studyProjectBoard;
}
