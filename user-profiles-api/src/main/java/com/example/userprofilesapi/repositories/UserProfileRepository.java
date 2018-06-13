package com.example.userprofilesapi.repositories;

import com.example.userprofilesapi.models.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
    @Query("SELECT u FROM UserProfile u where u.nickname = ?1")
    UserProfile findByNickname(String nickname);

//    @Transactional
//    @Query("DELETE from User u where u.username = :username")
//    void deleteByUsername(@Param("username")String username);


    @Transactional
    Long deleteByNickname(String nickname);

}