package com.plateforme.plateforme.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plateforme.plateforme.model.course;
@Repository
public interface courseReposetry  extends JpaRepository <course, Long >{
}
