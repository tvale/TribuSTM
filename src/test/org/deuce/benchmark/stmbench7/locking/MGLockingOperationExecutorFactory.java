package org.deuce.benchmark.stmbench7.locking;

import org.deuce.benchmark.stmbench7.OperationExecutor;
import org.deuce.benchmark.stmbench7.OperationExecutorFactory;
import org.deuce.benchmark.stmbench7.core.Operation;

/**
 * An implementation of the OperationExecutorFactory
 * for the medium-grained locking synchronization.
 */
public class MGLockingOperationExecutorFactory extends OperationExecutorFactory {

	@Override
	public OperationExecutor createOperationExecutor(Operation op) {
		return new MGLockingOperationExecutor(op);
	}
}
