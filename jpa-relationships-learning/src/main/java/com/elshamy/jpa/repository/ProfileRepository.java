package com.elshamy.jpa.repository;

import com.elshamy.jpa.model.Post;
import com.elshamy.jpa.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {



}