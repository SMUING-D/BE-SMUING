package dev.umc.smuing.communityReplyReply;

import dev.umc.smuing.community.Community;
import dev.umc.smuing.communityReply.CommunityReply;
import dev.umc.smuing.global.BaseEntity;
import dev.umc.smuing.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "community_reply_reply")
public class CommunityReplyReply extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_reply_reply_id")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_reply_id")
    private CommunityReply communityReply;
}
