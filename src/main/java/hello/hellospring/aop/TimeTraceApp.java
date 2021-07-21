package hello.hellospring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//������ �����̳ʿ� ������ ��� -> Spring Config ���Ͽ���
@Component
@Aspect //aop �� �� �ٿ��� ��
public class TimeTraceApp {

    //AOP ����� ����
    @Around("execution(* hello.hellospring..*(..))") //hello.hellospring ������ �� ����
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            //���� �޼���� ����
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}