package dev.umc.smuing.user;

import dev.umc.smuing.activity.Activity;
import dev.umc.smuing.career.Career;
import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentReport.CommentReport;
import dev.umc.smuing.educate.Educate;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.global.Enum.Grade;
import dev.umc.smuing.link.Link;
import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.postReport.PostReport;
import dev.umc.smuing.school.School;
import dev.umc.smuing.skill.Skill;
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
    @Column(name = "user_id", updatable = false)
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "password")
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    private String email;

    private String nickname;

    private String role;

    @Column(name = "skill")
    private String skill;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String profileImg;

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

    @OneToMany(mappedBy = "user")
    private List<Activity> activities = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Educate> educates = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Link> links = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Career> careers = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<School> schools = new ArrayList<>();
}
