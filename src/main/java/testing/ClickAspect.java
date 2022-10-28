package testing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ClickAspect {
    @Pointcut("@annotation(testing.Click) && execution(* *(..))")
    public void clickAnn() {
    }

    @Around("clickAnn()")
    public void clickOnAction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint + " -> Clicking on a button");
        joinPoint.proceed();
    }

    @AfterThrowing(pointcut = "execution(* testing.SeleniumAspectSupportTest.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws     Throwable  {
        System.out.println("Loi cmnr");
        System.out.println(ex.getMessage());
    }

}