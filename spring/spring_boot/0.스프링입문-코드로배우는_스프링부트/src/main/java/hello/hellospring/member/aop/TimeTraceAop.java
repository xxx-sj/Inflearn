package hello.hellospring.member.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

    @Around("execution(* hello.hellospring.member..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {

            Object result = joinPoint.proceed();
//            System.out.println("result = " + result);
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END : " + joinPoint.toString() + " " + timeMs  + "ms");
        }
    }
}
