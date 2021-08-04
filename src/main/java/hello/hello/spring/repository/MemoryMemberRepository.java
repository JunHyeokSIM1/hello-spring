package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //실무에서는 동시성 문제때문에 컨커러시블? 써야함함
    private static long sequence = 0L;

   @Override
    public Member save(Member member) {
       member.setId(++sequence);
       store.put(member.getId(), member);
       //스토어 넣기전에 맴버 아이디 값을 넘겨주고 이름은 넘어온상태
       // 아이디는 시스템이 정해준거고 스토어에 저장 그럼 멤버를 반환할것이다.
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       // null도 감쌀 수 있다 .
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return  store.values().stream()
               .filter(member -> member.getName().equals(name))
               .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
       store.clear();
    }


}
