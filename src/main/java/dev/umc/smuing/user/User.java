package dev.umc.smuing.user;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentReport.CommentReport;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.global.Enum.Grade;
import dev.umc.smuing.global.Enum.UndergraduateGraduate;
import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.postReport.PostReport;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    private String password;

    private String username;

    private String major;

    private String email;

    private String nickname;

    @Column(name = "desired_employment")
    private String desiredEmployment;

    private String role;

    @Column(name = "skill")
    private String skill;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String college;

    @Enumerated(EnumType.STRING)
    @Column(name = "undergraduate_graduate")
    private UndergraduateGraduate undergraduateGraduate;

    private String profile;

    @OneToMany(mappedBy = "user")
    private List<UserPost> userPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostComment> postComments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostReport> postReports = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommentReport> commentReports = new ArrayList<>();


}
