package com.maindish.querydsl.member;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRepositorySupport memberRepositorySupport;

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_basic_function_success() {
        // given
        String name = "maindish";
        String address = "maindish.75@gmail.com";
        memberRepository.save(new Member(name, address));

        // when
        List<Member> result = memberRepositorySupport.findByName(name);

        final Long actualId = result.get(0).getId();

        //then
        assertEquals(1L, actualId);
        assertEquals(1, result.size());
        assertEquals(address, result.get(0).getAddress());
    }
}
