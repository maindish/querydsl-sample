package com.maindish.querydsl.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> findByName(String name) {
        return jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.name.eq(name))
                .fetch();
    }
}
