package hello.core.singleton;

public class SingleTonService {

    //자기자신을 내부에 static으로 가지고 있다.
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    private SingleTonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
