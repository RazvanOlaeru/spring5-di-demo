package com.pentalog.razvan.spring5didemo;

import com.pentalog.razvan.spring5didemo.controllers.ConstructorInjectedController;
import com.pentalog.razvan.spring5didemo.controllers.MyController;
import com.pentalog.razvan.spring5didemo.controllers.PropertyInjectedController;
import com.pentalog.razvan.spring5didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		controller.hello();

		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}
