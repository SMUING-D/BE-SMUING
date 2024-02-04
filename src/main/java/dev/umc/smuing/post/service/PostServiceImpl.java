package dev.umc.smuing.post.service;

import dev.umc.smuing.global.Enum.CollegeType;
import dev.umc.smuing.global.Enum.PostType;
import dev.umc.smuing.mapping.UserPost;
import dev.umc.smuing.mapping.repository.UserPostRepository;
import dev.umc.smuing.post.Post;
import dev.umc.smuing.post.converter.PostConverter;
import dev.umc.smuing.post.dto.*;
import dev.umc.smuing.post.repository.PostRepository;
import dev.umc.smuing.postComment.dto.PostCommentResponseDto;
import dev.umc.smuing.postComment.service.PostCommentService;
import dev.umc.smuing.postLike.repository.PostLikeRepository;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import static dev.umc.smuing.user.converter.UserConverter.toUserDto;
import static dev.umc.smuing.post.converter.PostConverter.convertToPostDto;
import static dev.umc.smuing.post.converter.PostConverter.toPost;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserPostRepository userPostRepository;
    private final PostCommentService postCommentService;
    private final PostLikeRepository postLikeRepository;

    @Override
    public void postSave(PostRequestDto.PostSaveDto postSaveDto) {
        User user = findUserById(1L);
        Post post = toPost(postSaveDto);
        postRepository.save(post);
        saveUserPost(user, post);
    }

    // Main페이지 불러오기
    @Override
    public PostResponseDto.getAllMainPost getAllMainPost() {
        PostResponseDto.getAllMainPost getAllMainPost = PostResponseDto.getAllMainPost.builder()
                .popularPosts(getPopularPosts())
                .categories(getCategories())
                .build();

        return getAllMainPost;
    }

    @Override
    public void postUpdate(PostRequestDto.PostUpdateDto postUpdateDto,Long id) {
        // 1. 업데이트할 게시물을 데이터베이스에서 가져옵니다.
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));

        post.setTitle(postUpdateDto.getTitle());
        post.setContent(postUpdateDto.getContent());
        postRepository.save(post);
    }


    @Override
    public void postDelete(Long postId) {
        Post post = findPostById(postId);
        postRepository.delete(post);
    }

    @Override //단과대 조회
    public PostResponseDto getAllPostListByCollege(CollegeType college) {


        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto.PostDetailDto getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));

        return createPostDetailDto(post);
    }

    private PostResponseDto.PostDetailDto createPostDetailDto(Post post) {
        PostResponseDto.PostDetailDto postDetailDto;
        PostCommentResponseDto.Comments comments = postCommentService.getComments(0l, post.getId(), 1l);

        if (post.getPostType() == PostType.STUDY) {
            postDetailDto = PostResponseDto.PostDetailDto.builder()
                    .study(createStudyDto(post, comments))
                    .build();
        } else if (post.getPostType() == PostType.JOB) {
            postDetailDto = PostResponseDto.PostDetailDto.builder()
                    .job(createJobDto(post, comments))
                    .build();
        } else {
            throw new RuntimeException("유효하지 않은 게시물 유형입니다.");
        }

        return postDetailDto;
    }

    private PostTypeDto.StudyDto createStudyDto(Post post, PostCommentResponseDto.Comments comments) {
        return PostTypeDto.StudyDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .startDate(post.getStartDate().toString())
                .memberCount(Integer.parseInt(post.getMemberCount()))
                .dueDate(String.valueOf(post.getDueDate()))
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                .isPostLike(false)
                .college(post.getCollege())
                .postLikeCount(5)
                .userDto(toUserDto(findUserById(1L)))
                .comments(comments) //임시
                .postImageList(null) //임시
                .build();
    }

    private PostTypeDto.JobDto createJobDto(Post post, PostCommentResponseDto.Comments comments) {
        return PostTypeDto.JobDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .startDate(post.getStartDate().toString())
                .memberCount(Integer.parseInt(post.getMemberCount()))
                .dueDate(String.valueOf(post.getDueDate()))
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                .isPostLike(false)
                .college(post.getCollege())
                .postLikeCount(5)
                .userDto(toUserDto(findUserById(1L)))
                .comments(comments) //임시
                .postImageList(null) //임시
                .build();
    }



    @Override //수정해야함
    public void postUpdate(PostRequestDto.PostSaveDto postSaveDto) {
        User user = findUserById(1L);
        Post post = toPost(postSaveDto);
        postRepository.save(post);
        saveUserPost(user, post);
    }

    private void saveUserPost(User user, Post post) {
        UserPost userPost = UserPost.builder()
                .user(user)
                .post(post)
                .build();
        userPostRepository.save(userPost);
    }
    // PopularPostService로직
    public List<PopularPostDto> getPopularPosts() {
        List<Post> postList = postRepository.findTop5ByCollegeOrderByCreatedAtDesc(CollegeType.EDUCATE);
        List<PopularPostDto> popularPostDtoList = postList.stream()
                .map(post -> {
                    // 여기서 user, likeCount, isLike 값을 가져와야 함
                    User user = userRepository.findById(1L).get(); //임시 userId = 1
                    Integer likeCount = 5;
                    Boolean isLike = false; //임시로 false
                    return PostConverter.convertToPopularPostDto(post, user, likeCount, isLike);
                })
                .collect(Collectors.toList());

        return popularPostDtoList;
    }


    // CategoryService로직
    public Map<String, CategoryDto> getCategories() {
        Map<String, CategoryDto> categories = new HashMap<>();

        // 각 카테고리별로 데이터를 가져와서 설정합니다.
        for (CollegeType collegeType : CollegeType.values()) {
            CategoryDto category = new CategoryDto();
            List<PostDto> posts = getPostsForCategory(collegeType); // 해당 카테고리에 대한 포스트를 가져오는 메서드입니다.
            category.setPosts(posts);
            categories.put(collegeType.toString(), category);
        }

        return categories;
    }

    //단과대로 조회
    private List<PostDto> getPostsForCategory(CollegeType collegeType) {
        List<PostDto> postDtoList = findPostByCollegeType(collegeType);
        return postDtoList;
    }


    //단과대로 최신순으로 5개 조회
    public List<PostDto> findPostByCollegeType(CollegeType collegeType) {
        List<Post> posts = postRepository.findTop5ByCollegeOrderByCreatedAtDesc(collegeType);
        return posts.stream()
                .map(post -> {
                    Integer likeCount = postLikeRepository.countLikesByPostId(post.getId());
                    Boolean isLike = postLikeRepository.findByUserIdAndPostId(1L, post.getId()).isPresent();

//                    User writer = userPostRepository.findById(post.getId()).get().getUser();
                    User writer = userRepository.findById(1L).get();
                    return convertToPostDto(post, writer, likeCount, isLike);
                })
                .collect(Collectors.toList());
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }
    private Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시물을 찾을 수 없습니다."));
    }
}
