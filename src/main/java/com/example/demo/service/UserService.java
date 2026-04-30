package com.example.demo.service;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final AppUserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        AppUser user = AppUser.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .build();

        UserProfile profile = UserProfile.builder()
                .phone(request.getPhone())
                .address(request.getAddress())
                .user(user)
                .build();

        user.setProfile(profile);

        AppUser saved = userRepository.save(user);

        log.info("User created with id: {}", saved.getId());

        return UserResponse.builder()
                .id(saved.getId())
                .fullName(saved.getFullName())
                .email(saved.getEmail())
                .phone(saved.getProfile().getPhone())
                .address(saved.getProfile().getAddress())
                .build();
    }
}