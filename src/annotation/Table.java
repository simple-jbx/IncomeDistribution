package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)       //注解的目标是类
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	 public String tableName();//表名
	 public String tableComment() default "";//表注释
}
