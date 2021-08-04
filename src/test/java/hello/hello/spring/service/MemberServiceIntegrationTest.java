package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService service;
    @Autowired MemberRepository memberRepository;
    // test는 편한대로 해도 도기때문ㅇ에 필드 인젝션 해도 된다.

    @Test
    void join() {
        // given
        Member member1 = new Member();
        member1.setName("test123");

        // when
        Long saveId = service.join(member1);

        // then
        Member findMember =  service.findOne(saveId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());
        // 저장한 맴버이름이 파인드한 내용과 같냐?

    }
    @Test
    public void 중복_회원_예외(){
        // given 
        Member member1 = new Member();
        member1.setName("spring");
      
        Member member2 = new Member();
        member2.setName("spring");
        
        // when
        service.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        /**   service.join(member1);
        assertThrows(NullPointerException.class, () -> service.join(member2));
        */

        // then
        /** try {
            service.join(member2);
            fail("예외 발생 테스트 ");
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }



}