package com.example.profilematcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileMatcherApplication {
//    private final static Logger log = LoggerFactory.getLogger(ProfileMatcherApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProfileMatcherApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner clr(UserProfileRepository userProfileRepository) {
//        return args -> {
//            userProfileRepository.deleteAll();
//
//            UserProfile john = new UserProfile(UUID.randomUUID(), "John", "Doe", new HashSet<>(Arrays.asList("surgery")));
//            UserProfile jane = new UserProfile(UUID.randomUUID(), "Jane", "Doe", new HashSet<>(Arrays.asList("radiology, surgery")));
//
//            UserProfile savedJohn = userProfileRepository.save(john);
//            UserProfile savedJane = userProfileRepository.save(jane);
//
//            userProfileRepository.findAll()
//                    .forEach(v -> System.out.println("Vet: {}"+ v.getFirstName()));
//
//            userProfileRepository.findById(savedJohn.getId())
//                    .ifPresent(v -> System.out.println("Vet by id: {}" + v.getFirstName()));
//        };
//    }
}

