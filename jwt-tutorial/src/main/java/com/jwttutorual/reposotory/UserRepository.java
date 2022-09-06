package com.jwttutorual.reposotory;

import com.jwttutorual.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    //@EntityGraph 쿼리가 수행 될 때 Lazy조회가 아니고 Eager조회로 authorities정보를 같이 가져오게 된다.
}