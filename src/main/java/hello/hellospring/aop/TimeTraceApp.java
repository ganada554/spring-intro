package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//스프링 컨테이너에 빈으로 등록 -> Spring Config 파일에서
@Component
@Aspect //aop 쓸 때 붙여야 함
public class TimeTraceApp {

    //AOP 대상을 지정
    @Around("execution(* hello.hellospring..*(..))") //hello.hellospring 하위에 다 적용
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            //다음 메서드로 진행
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
