package com.vm.Vyas_Media.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vm.Vyas_Media.Entity.MovetoTrash;

@Repository
public interface MovetoTrashRepository extends JpaRepository<MovetoTrash, Long> {
	MovetoTrash findByContact(String contact);
}
