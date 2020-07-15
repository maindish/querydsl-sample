package com.maindish.querydsl.member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findByName(String name);
}
