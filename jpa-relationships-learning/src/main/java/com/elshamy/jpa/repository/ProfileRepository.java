package com.elshamy.jpa.repository;

import com.elshamy.jpa.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}