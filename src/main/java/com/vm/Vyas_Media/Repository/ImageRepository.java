package com.vm.Vyas_Media.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vm.Vyas_Media.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
	Optional<Image> findByName(String fileName);
}