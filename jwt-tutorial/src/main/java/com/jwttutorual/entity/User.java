package com.jwttutorual.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(length = 100)
    private String password;

    @Column(length = 50)
    private String nickname;

    @JsonIgnore
    @Column()
    private boolean activated;

    /*
    @ManyToMany, @JoinTable
     => User, Authority 테이블을 일대다, 다대일 관계의 조인 테이블로 정의
     */
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}
    //권한에 대한 관계
    //일대다, 다대일 관계의 조일 테이블로 정의했다는 뜻.
