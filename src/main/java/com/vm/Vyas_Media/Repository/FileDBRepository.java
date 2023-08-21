package com.vm.Vyas_Media.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.Vyas_Media.Entity.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}