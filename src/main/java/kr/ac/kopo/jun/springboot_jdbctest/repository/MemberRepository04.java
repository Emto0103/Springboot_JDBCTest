package kr.ac.kopo.jun.springboot_jdbctest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import kr.ac.kopo.jun.springboot_jdbctest.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class MemberRepository04 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Member> selectMethod() {
        String jpql = "select entity from Member entity";
        Query query = entityManager.createQuery(jpql);
        List<Member> memberlist = query.getResultList();
        return memberlist;
    }

    @Transactional
    public void insertMethod(Member member) {
        String jpql = "insert into Member (name, age, email) values (:e_name, :e_age, :e_email)";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();
    }

    public Member selectMethodById(int id) {
        String jpql = "select entity from Member entity where id = :e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

//    @GetMapping("/edit/{id}")
//    public String editMethod(@PathVariable(name = "id") int id, Model model) {
//        Member member = repository.selectMethodById(id);
//        model.addAttribute("member", member);
//        return "viewPage04_edit";
//    }

    @Transactional
    public void updateMethod(Member member) {
        String jpql = "update Member set name=:e_name, age=:e_age, email=:e_email where id=:e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.setParameter("e_id", member.getId());
        query.executeUpdate();
    }

    @Transactional
    public void deleteMethod(int id) {
        String jpql = "delete from Member where id=:e_id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("e_id", id);
        query.executeUpdate();
    }
}
