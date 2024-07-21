package com.qa.factory;

public class ThreadLocalConcept {


	// Create a ThreadLocal variable
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	public static void main(String[] args) {

		// Create and start two threads
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1 initial value: " + threadLocal.get());
			threadLocal.set(threadLocal.get() + 1);
			System.out.println("Thread 1 updated value: " + threadLocal.get());
		});

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2 initial value: " + threadLocal.get());
			threadLocal.set(threadLocal.get() + 2);
			System.out.println("Thread 2 updated value: " + threadLocal.get());
		});

		thread1.start();
		thread2.start();
	}


}
