package dev.umc.smuing.commentLike.converter;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.user.User;

public class CommentLikeConverter {
    public static CommentLike toCommentLike(User user, PostComment postComment) {
        return CommentLike.builder()
                .user(user)
                .postComment(postComment)
                .build();
    }
}
