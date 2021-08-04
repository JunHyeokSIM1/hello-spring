package hello.hello.spring;

import hello.hello.spring.repository.*;
import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    //JPA 랑 템플릿쓸때만
    private final DataSource dataSource;
    private final EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }


    //private final MemberRepository memberRepository;

   // @Autowired
   // public SpringConfig(MemberRepository memberRepository) {
    //    this.memberRepository = memberRepository;
   // }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    // memberRepository 이걸 넣어주면 엮어준다.




    //AOP 개념
/*    @Bean
    //@ComponentScans 써돋 ㅚㄴ다.
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/



    //설정 JPA 데이타
    @Bean
    public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
        return new JpaMemberRepository(em);

    }

}
