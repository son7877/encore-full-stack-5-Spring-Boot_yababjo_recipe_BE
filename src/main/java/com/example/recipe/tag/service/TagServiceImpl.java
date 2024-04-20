package com.example.recipe.tag.service;

import com.example.recipe.global.domain.entity.Tag;
import com.example.recipe.global.domain.repository.TagRepository;
import com.example.recipe.tag.dto.Request.TagRequest;
import com.example.recipe.tag.dto.Response.TagResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public void save(TagRequest req) {
       tagRepository.save(req.toEntity(req));
    }

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = new ArrayList<>();
        List<Tag> all = tagRepository.findAll();
        tags.addAll(all);

        return tags;
    }

    @Override
    public List<Tag> findByKeyword(String keyword) {

        List<Tag> tags = new ArrayList<>();
        List<Tag> byKeyword = tagRepository.findByKeyword(keyword);
        tags.addAll(byKeyword);

        return tags;
    }


}
