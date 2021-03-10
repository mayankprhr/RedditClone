package com.java.reddit.repository;

import java.util.Optional;

import com.java.reddit.model.VerificationToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {

    Optional<VerificationToken> findByToken(String  token);
}
