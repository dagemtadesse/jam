package com.rune.Jam.controllers;

import com.rune.Jam.models.Comment;
import com.rune.Jam.models.Post;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.CommentRepository;
import com.rune.Jam.repositories.PostRepository;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final ChannelRepository chanRepo;
    private final CommentRepository commentRepo;

    @PostMapping("/create-post/{channelId}")
    public String createPost(@PathVariable Long channelId,  Post newPost, Authentication authentication){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);
        var channel = chanRepo.findById(channelId);

        if( user != null && channel.isPresent()){
            newPost.setCreator(user);
            newPost.setContextChannel(channel.get());
            newPost.setDate(new Date());
            postRepo.save(newPost);
        }

        return "redirect:/search";
    }

    @PostMapping("/create-comment/{postId}")
    public String createComment(@PathVariable Long postId, Comment comment, Authentication authentication){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        var post = postRepo.findById(postId);
        if( user != null && post.isPresent()){
            comment.setUser(user);
            comment.setPost(post.get());

            commentRepo.save(comment);
        }

        return "redirect:/search";
    }
}
