package dev.umc.smuing.post;

import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.postImage.PostImage;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.global.Enum.PostType;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.postReport.PostReport;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post")
public class Post extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "member_count")
    private String memberCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type")
    private PostType postType;

    @Column(name = "due_date")
    private LocalDateTime dueDate;


    //5개 타입(Enum)
    @Column(name = "college")
    @Enumerated(EnumType.STRING)
    private CollegeType college;

    @Column(name = "view_count")
    private Integer viewCount;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostComment> postComments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> postImages = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<UserPost> userPosts = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostReport> postReports = new ArrayList<>();

    // 비즈니스 로직
    public Integer getLikeSum() {
        return postLikes.size();
    }
}
