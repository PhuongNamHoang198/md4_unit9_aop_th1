package cg.wbd.grandemonstration.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
// Aspect i
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))", throwing = "e")
    // pointcut là một biểu thức chứa các điều kiện để xác định các phương thức nào sẽ được chạy trước hoặc sau khi chạy phương thức mà chúng ta muốn theo dõi.
    // execution(public * cg.wbd.grandemonstration.service.CustomerService.*(..))
    // public: là quyền truy cập của phương thức
    // *: là kiểu trả về của phương thức
    // cg.wbd.grandemonstration.service.CustomerService: là tên của class chứa phương thức
    // *: là tên của phương thức
    // (..): là tham số của phương thức
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
}