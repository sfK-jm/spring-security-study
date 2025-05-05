package io.security.springsecuritystudy.admin.service.impl;

import io.security.springsecuritystudy.admin.repository.ResourcesRepository;
import io.security.springsecuritystudy.admin.service.ResourcesService;
import io.security.springsecuritystudy.domain.entity.Resources;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final ResourcesRepository resourcesRepository;

    @Transactional
    @Override
    public Resources getResources(long id) {
        return resourcesRepository.findById(id).orElse(new Resources());
    }

    @Transactional
    @Override
    public List<Resources> getResources() {
        return resourcesRepository.findAll(
                Sort.by(Sort.Order.asc("orderNum"))
        );
    }

    @Transactional
    @Override
    public void createResources(Resources resources) {
        resourcesRepository.save(resources);
    }

    @Transactional
    @Override
    public void deleteResources(long id) {
        resourcesRepository.deleteById(id);
    }
}
