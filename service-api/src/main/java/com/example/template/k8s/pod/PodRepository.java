package com.example.template.k8s.pod;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PodRepository extends CrudRepository<Pod, String> {

    Iterable<Pod> findByProvider(@Param("provider") String provider);
    Iterable<Pod> findByProviderAndName(@Param("provider") String provider,@Param("name") String name);
}