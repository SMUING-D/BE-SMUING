package dev.umc.smuing.communityReply;

import dev.umc.smuing.community.Community;
import dev.umc.smuing.communityReplyReply.CommunityReplyReply;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "community_reply")
public class CommunityReply extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_reply_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "communityReply")
    private List<CommunityReplyReply> communityReplyReplies = new ArrayList<>();
}
