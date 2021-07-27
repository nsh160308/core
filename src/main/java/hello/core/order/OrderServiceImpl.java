package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    /**
     * final 키워드가 있으면 무조건 할당이 되어야 한다.
     * */
    //회원 찾기
    private final MemberRepository memberRepository;
    //할인 정책
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
//고정 할인 정책
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //정률 할인 정책
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //인터페이스에만 의존하도록 재설계 DIP를 지켰으나 구체 클래스가 없기 때문에 컴파일 에러
//    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//회원조회
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
