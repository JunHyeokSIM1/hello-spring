package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
//인터페이스가 인터페이스를 상속받을때는 extends 를 사용한다.
// JpaRepository 받고있으면 자동으로 구현체를 만들어 준다.

    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
