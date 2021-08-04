package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService( MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*    회원가입*/
    public Long join(Member member){
        // 중복체크
    /*    Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });*/

        // ifPresent 이값이 있으면?  동작한는 코드 옵셔널이라 동작하는 코드이다. 옵셔널을 통해 쓸 있다.
        // orget 을 많이 쓴다 옵셔널은 바로 반환 권장x 이런식으로 코드를 줄여서 작성할 수 있다.
        // 컨트롤 티 하면 리팩토링 관련 단축키이다.

        validateDuplicateMember(member); //검증후 저장하는 로직완성 !
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
    /*전체회원조회*/
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    //서비스 클래스는 비지늬스 내임으로 설계를해라 !

}
