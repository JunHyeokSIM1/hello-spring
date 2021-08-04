package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 콜백 코드실행시 계속호출되서 비워주는것
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
      /**System.out.println("result "+ (result == member));
        Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);*/
        assertThat(member).isEqualTo(result);
        // 이런게 스테틱 임폴트 되어서 발바로 선언도 가능한 짱좋은 기능이다. 
        //옵션엔터
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring2");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring3");
        repository.save(member2);

        Member result =  repository.findByName("Spring2").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member3 = new Member();
        member3.setName("Spring4");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("Spring4");
        repository.save(member4);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }



}
