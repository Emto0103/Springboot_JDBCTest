package kr.ac.kopo.jun.springboot_jdbctest.repository;

import kr.ac.kopo.jun.springboot_jdbctest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository02 extends JpaRepository<Member, Integer> {

}
