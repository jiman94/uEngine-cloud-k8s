package com.example.template.k8s.deployment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DeploymentRepository extends CrudRepository<Deployment, String> {

    Iterable<Deployment> findByHost(@Param("host") String host);
    Iterable<Deployment> findByHostAndNamespace(@Param("host") String host, @Param("namespace") String namespace);
    Iterable<Deployment> findByHostAndNamespaceAndName(@Param("host") String host, @Param("namespace") String namespace, @Param("name") String name);

    @Transactional
    @Modifying
    @Query("delete from Deployment")
    void deleteAllInQuery();

    @Modifying
    @Transactional
    @Query(value="DELETE FROM DEPLOYMENT WHERE host=?1",
            nativeQuery = true)
    void deleteByHost(@Param("host") String host);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM DEPLOYMENT WHERE host=?1 and namespace=?2 and name =?3 ",
            nativeQuery = true)
    void deleteDeploy(@Param("host") String host, @Param("namespace") String namespace, @Param("name") String name);

}
