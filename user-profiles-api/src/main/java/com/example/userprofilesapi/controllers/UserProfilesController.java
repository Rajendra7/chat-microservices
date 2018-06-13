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
    private UserProfileRepository userProfileRepository;

    @GetMapping("/user-profiles")
    public Iterable<UserProfile> findAllUserProfiles() {
        return userProfileRepository.findAll();
    }

//    @GetMapping("/user-profiles/{userProfileId}")
//    public Optional<UserProfile> findUserProfileById(@PathVariable Long userProfileId) {
//        return userProfileRepository.findById(userProfileId);
//    }

//    @DeleteMapping("/user-profiles/{userProfileId}")
//    public HttpStatus deleteUserProfileById(@PathVariable Long userProfileId) {
//        userProfileRepository.deleteById(userProfileId);
//        return HttpStatus.OK;
//    }

    @GetMapping("/user-profiles/name/{nickname}")
    public UserProfile findByNickname(@PathVariable String nickname) {
        return userProfileRepository.findByNickname(nickname);
    }

    @PostMapping("/user-profiles")
    public UserProfile createNewUserProfile(@RequestBody UserProfile newUserProfile) {
        return userProfileRepository.save(newUserProfile);
    }

//    @PatchMapping("/user-profiles/{userProfileId}")
//    public UserProfile updateUserProfileById(@PathVariable Long userProfileId, @RequestBody UserProfile userProfileRequest) {
//
//        UserProfile userProfileFromDb = userProfileRepository.findById(userProfileId).get();
//        userProfileFromDb.setBio(userProfileRequest.getBio());
//        return userProfileRepository.save(userFromDb);
//    }
    @DeleteMapping("/user-profiles/name/{nickname}")
    public HttpStatus deleteByNickname(@PathVariable String nickname) {
        userProfileRepository.deleteByNickname(nickname);
        return HttpStatus.OK;
    }

    @PatchMapping("/user-profiles/name/{nickname}")
    public UserProfile updateByNickname(@RequestBody UserProfile userProfileRequest, @PathVariable String nickname){
        UserProfile userProfileFromDb = userProfileRepository.findOne(nickname);
        userProfileFromDb.setBio(userProfileRequest.getBio());
//        userFromDb.setPassword(userRequest.getPassword());
        return userProfileRepository.save(userProfileFromDb);
    }
}