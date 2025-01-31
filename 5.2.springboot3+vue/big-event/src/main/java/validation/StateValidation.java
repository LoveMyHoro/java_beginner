package validation;

import com.horo.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @ClassName StateValidation
 * @Author iove
 * @Date 2024/11/4 下午5:36
 * @Version 1.0
 * @Description TODO 这个是为自定义校验注解提供校验规则道德类
 **/

//ConstraintValidator<要提供校验规则的自定义校验类，校验的数据类型>
public class StateValidation implements ConstraintValidator<State,String>{
    /**
     *
     * @param s 将来要校验的数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if(s==null){
            return false;
        }
        if(s.equals("已发布")||s.equals("草稿")){
            return true;
        }
        return false;
    }
}
