package com.innovativetecnologia.springboot2mongodb.config;

import com.innovativetecnologia.springboot2mongodb.domain.Post;
import com.innovativetecnologia.springboot2mongodb.domain.User;
import com.innovativetecnologia.springboot2mongodb.dto.AuthorDTO;
import com.innovativetecnologia.springboot2mongodb.repository.PostRepository;
import com.innovativetecnologia.springboot2mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post pos1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post pos2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei felix hoje!", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(pos1, pos2));
    }
}
