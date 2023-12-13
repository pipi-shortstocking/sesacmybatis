package sesac.mybatis.sesacmybatis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sesac.mybatis.sesacmybatis.domain.User;
import sesac.mybatis.sesacmybatis.entity.UserEntity;

import java.util.List;
import java.util.Optional;

// Repository : 만들어진 DB 구조에 CRUD 하기 위해서 필요한 메소드를 정의하는 계층
// JpaRepository<대상으로 지정할 Entity, 해당 Entity의 pk타입>
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // Optional : java 8 이후부터 등장한 친구
    // null일 수도 있는 객체를 감싸는 wrapper 크래스
    // Optional<T> : null일 수도 있는 단일값을 표현할 때 사용하는 것이 권장됨


    // findBy를 이용하고 단일값으로 받으면 ( UserEntity, Optional<UserEntity> )
    // 검색된 값이 2개 이상일 때 에러가 난다.
    // List<UserEntity> findBy컬럼명
//    Optional<UserEntity> findByName(String name);
    List<UserEntity> findByName(String name);
    // findBy 뒤에는 컬럼명이 upper case 된 형태로 들어온다.
//    Optional<UserEntity> findByNickname(String nickname); // 조건에 nickname을 걸어서 실행하겠다.
    List<UserEntity> findByNickname(String nickname);

    // 아래 쿼리는 findBy 뒤에 컬럼명이 upper case로 된 형태로 들어오지 않을 때(JPA 규칙에 어긋남) 실행되는 것
    // 즉, 쿼리 어노테이션 + JPA 규칙을 동시에 한다면 쿼리가 2개가 되는 것
//    @Query("select u from UserEntity u where u.name=:name and u.nickname=:nickname")
//    @Query(nativeQuery = true, value="select * from user where name=:name and nickname=:nickname")
//    Optional<UserEntity> findByNameAndNickname(String name, String nickname);
    List<UserEntity> findByNameAndNickname(String name, String nickname);

    List<UserEntity> findByNameOrNickname(String name, String nickname);

//    @Query(nativeQuery = true, value="select * from user2 where name=:name")
//    UserEntity findExist(String name);
    // JPA 메소드 존재
    boolean existsByName(String name);
}
