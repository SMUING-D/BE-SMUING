package dev.umc.smuing.global.token;

import dev.umc.smuing.global.apiPayload.code.status.ErrorStatus;
import dev.umc.smuing.global.apiPayload.exception.UserException;
import dev.umc.smuing.user.User;
import dev.umc.smuing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class ExtractUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory)
            throws Exception {

        String accessRequestToken = webRequest.getHeader("Authorization");
        String accessToken = jwtTokenProvider.resolveToken(accessRequestToken);
        String student_id = jwtTokenProvider.getStudentId(accessToken);
        User user = userRepository.findUserByStudentId(student_id).orElseThrow(()-> new UserException(ErrorStatus.USER_NOT_FOUND));
        return user.getId();
    }
}
