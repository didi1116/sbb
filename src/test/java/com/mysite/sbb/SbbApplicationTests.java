package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRespository;


    @Test
    void questionInsertTest() {
        Question question = new Question();
        question.setSubject("sbb가 무엇인가요?");
        question.setContent("sbb에 대해 알고 싶어요");
        question.setCreateTime(LocalDateTime.now());
        this.questionRespository.save(question);

        Question question2 = new Question();
        question2.setSubject("스프링부트 모델 질문입니다");
        question2.setContent("id는 자동 생성 되나요?");
        question2.setCreateTime(LocalDateTime.now());
        this.questionRespository.save(question2);
    }

    @Test
    void questionUpdateTest() {
        List<Question> all = this.questionRespository.findAll();
        assertEquals(4,all.size());
    }

    @Test
    void questionFindAllTest() {
        List<Question> all = this.questionRespository.findAll();
        assertEquals(4, all.size());

        Question q = all.getFirst();
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void questionFindByIdTest() {
        Optional<Question> oq = this.questionRespository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getId());

        }
    }




    }
}
