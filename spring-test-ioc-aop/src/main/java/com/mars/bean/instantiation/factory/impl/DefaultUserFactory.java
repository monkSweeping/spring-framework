package com.mars.bean.instantiation.factory.impl;

import com.mars.bean.instantiation.factory.UserFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

/**
 * @author doujiang
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


	/**
	 * 初始化方法
	 */
	public void initUserFactory(){
		System.out.println("自定义初始化方法 initUserFactory(): UserFactory 初始化中。。。。");
	}

	/**
	 * 初始化方法
	 */
	@PostConstruct
	public void init(){
		System.out.println("@PostConstruct UserFactory 初始化中。。。。");
	}


	/**
	 * 初始化方法
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean#afterPropertiesSet(): UserFactory 初始化中。。。。");
	}

	/**
	 * 销毁方法
	 */
	public void doDestroy(){
		System.out.println("自定义初始化方法 doDestroy(): UserFactory 销毁中。。。。");
	}

	/**
	 * 销毁方法
	 */
	@PreDestroy
	public void preDestroyUserFactory(){
		System.out.println("@PreDestroy preDestroyUserFactory(): UserFactory 销毁中。。。。");
	}

	/**
	 * 销毁方法
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean#destroy(): UserFactory 销毁中。。。。");
	}

	/**
	 * Called by the garbage collector on an object when garbage collection
	 * determines that there are no more references to the object.
	 * A subclass overrides the {@code finalize} method to dispose of
	 * system resources or to perform other cleanup.
	 * <p>
	 * The general contract of {@code finalize} is that it is invoked
	 * if and when the Java&trade; virtual
	 * machine has determined that there is no longer any
	 * means by which this object can be accessed by any thread that has
	 * not yet died, except as a result of an action taken by the
	 * finalization of some other object or class which is ready to be
	 * finalized. The {@code finalize} method may take any action, including
	 * making this object available again to other threads; the usual purpose
	 * of {@code finalize}, however, is to perform cleanup actions before
	 * the object is irrevocably discarded. For example, the finalize method
	 * for an object that represents an input/output connection might perform
	 * explicit I/O transactions to break the connection before the object is
	 * permanently discarded.
	 * <p>
	 * The {@code finalize} method of class {@code Object} performs no
	 * special action; it simply returns normally. Subclasses of
	 * {@code Object} may override this definition.
	 * <p>
	 * The Java programming language does not guarantee which thread will
	 * invoke the {@code finalize} method for any given object. It is
	 * guaranteed, however, that the thread that invokes finalize will not
	 * be holding any user-visible synchronization locks when finalize is
	 * invoked. If an uncaught exception is thrown by the finalize method,
	 * the exception is ignored and finalization of that object terminates.
	 * <p>
	 * After the {@code finalize} method has been invoked for an object, no
	 * further action is taken until the Java virtual machine has again
	 * determined that there is no longer any means by which this object can
	 * be accessed by any thread that has not yet died, including possible
	 * actions by other objects or classes which are ready to be finalized,
	 * at which point the object may be discarded.
	 * <p>
	 * The {@code finalize} method is never invoked more than once by a Java
	 * virtual machine for any given object.
	 * <p>
	 * Any exception thrown by the {@code finalize} method causes
	 * the finalization of this object to be halted, but is otherwise
	 * ignored.
	 *
	 * @throws Throwable the {@code Exception} raised by this method
	 * @jls 12.6 Finalization of Class Instances
	 * @see WeakReference
	 * @see PhantomReference
	 */
	@Override
	public void finalize() throws Throwable {
		System.out.println("当前 DefaultUserFactory 对象正被垃圾回收中。。。");
	}
}
