package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Name {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Greet greet = ctx.getBean("greet", Greet.class);
		greet.hello();
		
		Greet greet2 = ctx.getBean("greet", Greet.class);
		greet2.hello();
		
		ctx.close();
	}

}
