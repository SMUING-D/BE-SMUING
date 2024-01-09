package dev.umc.smuing.user;

import dev.umc.smuing.community.Community;
import dev.umc.smuing.communityReply.CommunityReply;
import dev.umc.smuing.communityReplyReply.CommunityReplyReply;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.studyProjectReply.StudyProjectReply;
import dev.umc.smuing.studyProjectReplyReply.StudyProjectReplyReply;
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

    private String studentId;

    private String password;

    private String name;

    private String major;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Community> communities = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommunityReplyReply> communityReplyReplies = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommunityReply> communityReplies = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserStudyProject> userStudyProjects = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StudyProjectReply> studyProjectReplies = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StudyProjectReplyReply> studyProjectReplyReplies = new ArrayList<>();



}
