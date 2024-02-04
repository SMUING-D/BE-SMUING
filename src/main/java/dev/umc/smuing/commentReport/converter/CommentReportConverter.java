package dev.umc.smuing.commentReport.converter;

import dev.umc.smuing.commentLike.CommentLike;
import dev.umc.smuing.commentReport.CommentReport;
import dev.umc.smuing.postComment.PostComment;
import dev.umc.smuing.user.User;

public class CommentReportConverter {

    public static CommentReport toCommentReport(User user, PostComment postComment) {
        return CommentReport.builder()
                    .user(user)
                    .postComment(postComment)
                    .build();
    }
}
