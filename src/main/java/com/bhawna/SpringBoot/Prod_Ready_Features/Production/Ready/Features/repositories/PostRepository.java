package com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.repositories;

import com.bhawna.SpringBoot.Prod_Ready_Features.Production.Ready.Features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
