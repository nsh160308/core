package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //인터페이스가 필요 && 구현체를 가져야 기능수행 clear 구현체도 알게되니까 DIP 무시
    private final MemberRepository memberRepository;

    @Autowired//ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입 구현
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //회원조회 구현
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
