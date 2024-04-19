package com.example.recipe.comment.service;

import com.example.recipe.comment.dto.request.CommentRequest;
import com.example.recipe.comment.dto.response.CommentResponse;
import com.example.recipe.global.domain.entity.Comment;
import com.example.recipe.global.domain.entity.Recipe;
import com.example.recipe.global.domain.entity.Type;
import com.example.recipe.global.domain.entity.User;
import com.example.recipe.global.domain.repository.CommentRepository;
import com.example.recipe.global.domain.repository.RecipeRepository;
import com.example.recipe.global.domain.repository.TypeRepository;
import com.example.recipe.global.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentServiceImplTest {
    Comment comment;

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Test
    void save() {
        init();
        CommentRequest req = new CommentRequest(
                comment.getContent(),
                comment.getUser().getId(),
                comment.getRecipe().getId()
        );
        commentService.save(req);
    }

    @BeforeEach
    void init(){
        User user = User.builder().id(1L).build();
        userRepository.save(user);
        Type type = Type.builder().id(1L).build();
        typeRepository.save(type);
        Recipe recipe = Recipe.builder()
                .id(1L)
                .foodName("test")
                .recipeTitle("test")
                .user(user)
                .type(type).build();
        // UserRepository와 RecipeRepository를 사용하여 데이터베이스에 저장
        recipeRepository.save(recipe);

        comment = Comment.builder()
                .user(user)
                .content("test")
                .recipe(recipe)
                .createdAt(LocalDateTime.now()) // createdAt도 초기화
                .build();
    }
}
