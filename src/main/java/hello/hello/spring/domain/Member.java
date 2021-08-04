package hello.hello.spring.domain;

import javax.persistence.*;

@Entity
// 자바과 관리하는 Entity 어노테이션
public class Member {

    @Id                                                  //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //쿼리를 잘보면 id가 자동으로 생기는데 identity전략이라고도한다. (=시퀀스)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
