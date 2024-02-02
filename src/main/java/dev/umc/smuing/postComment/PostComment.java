package dev.umc.smuing.postComment;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentReport.CommentReport;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.postLike.PostLike;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "post_comment")
public class PostComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private Long id;

    private String content;

    //보류
    private Integer likes;
    //보류
    private Integer reports;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private PostComment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<PostComment> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "postComment")
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "postComment")
    private List<CommentReport> commentReports = new ArrayList<>();

    // 연관 관계 편의 메소드
    public void setUser (User user) {
        this.user = user;
    }
    public void setPost (Post post) {
        this.post = post;
    }
    public void setComment(PostComment postComment) {
        this.parent = postComment;
    }
    
    // 기능 메소드
    public void deleteComment() {
        this.content = null;
    }

    public int getLikeSum() {
        return commentLikes.size();
    }

    public int getReportSum() {
        return commentReports.size();
    }
    
    public void updateComment(String content) {
        this.content = content;
    }

    public boolean isMyLike(User user) {
        for(CommentLike commentLike : this.commentLikes) {
            if(commentLike.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMyReport(User user) {
        for(CommentReport commentReport : this.commentReports) {
            if(commentReport.getUser().equals(user)) {
              return true;
            }
        }

        return false;
    }
}
