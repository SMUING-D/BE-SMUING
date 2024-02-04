package dev.umc.smuing.postLike.service;

import dev.umc.smuing.postLike.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostLikeServiceImpl implements PostLikeService{
    private final PostLikeRepository postLikeRepository;
    @Override
    public void savePostLike() {

    }

    @Override
    public void deletePostLike() {

    }
}
