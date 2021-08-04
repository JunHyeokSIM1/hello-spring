package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    // 아이디, 네임으로 찾을수있다.
    Optional<Member> findByName(String name);
    // null 반환하는 대신에 이걸 감싸서 반환한다
    List<Member> findAll();

}
