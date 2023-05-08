package com.cantt39t.fitnesswebapp.repository;

import com.cantt39t.fitnesswebapp.model.Comment;
import com.cantt39t.fitnesswebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {



}
