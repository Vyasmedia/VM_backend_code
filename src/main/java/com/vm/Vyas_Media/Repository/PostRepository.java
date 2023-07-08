package com.vm.Vyas_Media.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vm.Vyas_Media.Entity.Posts;

public interface PostRepository extends JpaRepository<Posts,Integer> {
}
