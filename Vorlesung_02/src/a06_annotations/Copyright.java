package a06_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.categories.Categories.ExcludeCategory;

@Retention(RetentionPolicy.RUNTIME)
public @interface Copyright {
	String value() default "Michael Uhl";
}
