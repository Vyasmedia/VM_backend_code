package com.vm.Vyas_Media.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.Vyas_Media.Entity.Comment;


public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
