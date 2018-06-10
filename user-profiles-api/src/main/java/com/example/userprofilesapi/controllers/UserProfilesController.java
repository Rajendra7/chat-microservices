package com.example.userprofilesapi.controllers;

import com.example.userprofilesapi.models.UserProfile;
import com.example.userprofilesapi.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserProfilesController {

    @Autowired
    private UserProfilesRepository userProfilesRepository;

    @GetMapping("/userprofiles")
    public Iterable<UserProfile> findAllUsers() {
        return userProfilesRepository.findAll();
    }

    @GetMapping("/userprofiles/{userId}")
    public Optional<UserProfile> findUserProfileById(@PathVariable Long userId) {
        return userProfilesRepository.findById(userId);
    }

    @DeleteMapping("/userprofiles/{userId}")
    public HttpStatus deleteUserProfileById(@PathVariable Long userId) {
        userProfilesRepository.deleteById(userId);
        return HttpStatus.OK;
    }

    @GetMapping("/userprofiles/name/{nickname}")
    public Optional<UserProfile> findByNickname(@PathVariable String nickname) {
        return userProfilesRepository.findByNickname(nickname);
    }

    @PostMapping("/userprofiles")
    public User createNewUserProfile(@RequestBody UserProfile newUserProfile) {
        return userProfilesRepository.save(newUserProfile);
    }

    @PatchMapping("/userprofiles/{userId}")
    public UserProfile updateUserProfileById(@PathVariable Long userId, @RequestBody UserProfile userProfileRequest) {

        UserProfile userProfileFromDb = userProfilesRepository.findById(userId).get();
        userProfileFromDb.setBio(userProfileRequest.getBio());
        return userProfilesRepository.save(userFromDb);
    }
    @DeleteMapping("/userprofiles/name/{nickname}")
    public HttpStatus deleteByNickname(@PathVariable String nickname) {
        userProfilesRepository.deleteByNickname(nickname);
        return HttpStatus.OK;
    }

    @PatchMapping("/userprofiles/name/{nickname}")
    public UserProfile updateByNickname(@RequestBody UserProfile userProfileRequest, @PathVariable String nickname){
        UserProfile userProfileFromDb = userProfileRepository.findByNickname(nickname).get();
        userProfileFromDb.setNickname(userProfileRequest.getNickname());
//        userFromDb.setPassword(userRequest.getPassword());
        return userProfileRepository.save(userProfileFromDb);
    }
}