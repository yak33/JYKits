package com.junya.core.thread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * ExecutorService代理
 *
 * @author zhangchao
 */
public class DelegatedExecutorService extends AbstractExecutorService {
	private final ExecutorService e;

	DelegatedExecutorService(ExecutorService executor) {
		e = executor;
	}

	@SuppressWarnings("NullableProblems")
	public void execute(Runnable command) {
		e.execute(command);
	}

	public void shutdown() {
		e.shutdown();
	}

	@SuppressWarnings("NullableProblems")
	public List<Runnable> shutdownNow() {
		return e.shutdownNow();
	}

	public boolean isShutdown() {
		return e.isShutdown();
	}

	public boolean isTerminated() {
		return e.isTerminated();
	}

	@SuppressWarnings("NullableProblems")
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return e.awaitTermination(timeout, unit);
	}

	@SuppressWarnings("NullableProblems")
	public Future<?> submit(Runnable task) {
		return e.submit(task);
	}

	@SuppressWarnings("NullableProblems")
	public <T> Future<T> submit(Callable<T> task) {
		return e.submit(task);
	}

	@SuppressWarnings("NullableProblems")
	public <T> Future<T> submit(Runnable task, T result) {
		return e.submit(task, result);
	}

	@SuppressWarnings("NullableProblems")
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return e.invokeAll(tasks);
	}

	@SuppressWarnings("NullableProblems")
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		return e.invokeAll(tasks, timeout, unit);
	}

	@SuppressWarnings("NullableProblems")
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		return e.invokeAny(tasks);
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		return e.invokeAny(tasks, timeout, unit);
	}
}
