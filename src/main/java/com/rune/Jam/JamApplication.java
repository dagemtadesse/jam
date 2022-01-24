package com.rune.Jam;

import com.rune.Jam.models.Channel;
import com.rune.Jam.models.Comment;
import com.rune.Jam.models.Post;
import com.rune.Jam.models.User;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.CommentRepository;
import com.rune.Jam.repositories.PostRepository;
import com.rune.Jam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class JamApplication{

	public static void main(String[] args) {
		SpringApplication.run(JamApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepository, ChannelRepository channelRepository, PostRepository postRepository) {
		return args -> {
			var AAU = new Channel("AAU", null, "Addis Ababa University", "AA", "aau@aau.edu.et", true);
			var BDU = new Channel("BDU", null, "Bahir Dar University", "BD", "bdu@bdu.edu.et", false);
			var AAiT = new Channel("AAiT", null, "Addis Ababa Institute of Technology", "AA", "aau@aau.edu.et", true);
//
			AAiT.setParentChannel(AAU);

			var dagem = new User("Dagem Tadesse", "dagem@gmail.com", "+251 999 999 999", "student");
//		var naomi = new User("Naomi", "naomi", "naomi@gmail.com", "+251 999 999 999", "student", User.Role.ADMIN);
//		var yeabsra = new User("Yeabsra", "yeab", "yl@gmail.com", "+251 999 999 999", "student", User.Role.REGULAR);
//		var hela = new User("Helawit GebreEyesus", "g_sus", "yl@gmail.com", "+251 999 999 999", "student", User.Role.REGULAR);
//		var tsega = new User("tsega GebreEyesus", "tsi", "tsi@gmail.com", "+251 999 999 999", "student", User.Role.ADMIN);
//
//		AAU.setCreator(naomi);
//		AAiT.setCreator(naomi);
//		AAiT.setParentChannel(AAU);
//
			var first = new Post("First post oh how the food is terible in AAU", dagem, AAU);
//		var firstComment = new Comment("Really, the food in AAit it good", first, naomi);
//		var secondComment = new Comment("The food is so awful man", first, yeabsra);
//
			var second = new Post("Quick update tomorrow i'm planning on mass shouting. Come and watch the spectacle", dagem, AAU);
//		var thirdComment = new Comment("sike", second, dagem);
			var third = new Post("new Event in AAit", dagem, AAiT);
//
			userRepository.saveAll(Arrays.asList(dagem));
			channelRepository.saveAll(Arrays.asList(AAU, AAiT, BDU));
			postRepository.saveAll(Arrays.asList(first, second, third));
//		commentRepository.saveAll(Arrays.asList(firstComment, secondComment, thirdComment));
//
//		naomi.setBookmarks(Arrays.asList(AAU, AAiT));
//		userRepository.save(naomi);
		};
	}
}
