package com.mars.bean.garbage;

import com.mars.bean.initialization.BeanInitializationDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author doujiang
 * TODO Bean 垃圾回收
 * TODO Spring 中的Bean 是可以被垃圾回收的
 * TODO 首先IOC 容器要关闭
 */
public class BeanGarbageCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// TODO 注册配置类
		applicationContext.register(BeanInitializationDemo.class);

		// TODO 启动 Spring 应用上下文
		applicationContext.refresh();

		// TODO 关闭 Sprig 应用上下文
		applicationContext.close();

		Thread.sleep(10000L);
		// TODO 强制执行GC
		System.gc();
		Thread.sleep(10000L);
	}
}
