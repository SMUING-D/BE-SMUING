package dev.umc.smuing.user;

import dev.umc.smuing.community.Community;
import dev.umc.smuing.communityComment.CommunityComment;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.global.Enum.UndergraduateGraduate;
import dev.umc.smuing.studyProjectComment.StudyProjectComment;
import dev.umc.smuing.mapping.UserStudyProject;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    private String password;

    private String name;

    private String major;

    private String email;

    private String nickname;

    @Column(name = "desired_employment")
    private String desiredEmployment;

    @Column(name = "skill")
    private String skill;

    private Integer grade;

    private String college;

    @Enumerated(EnumType.STRING)
    @Column(name = "undergraduate_graduate")
    private UndergraduateGraduate undergraduateGraduate;

    private String profile;

    @OneToMany(mappedBy = "user")
    private List<Community> communities = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommunityComment> communityComments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserStudyProject> userStudyProjects = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StudyProjectComment> studyProjectComments = new ArrayList<>();
}
