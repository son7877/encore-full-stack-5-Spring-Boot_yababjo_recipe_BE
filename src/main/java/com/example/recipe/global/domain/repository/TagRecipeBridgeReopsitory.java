package com.example.recipe.global.domain.repository;

import com.example.recipe.global.domain.entity.TagRecipeBridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRecipeBridgeReopsitory
        extends JpaRepository<TagRecipeBridge,Long> {
}
