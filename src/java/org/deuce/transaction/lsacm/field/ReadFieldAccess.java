package org.deuce.transaction.lsacm.field;

import org.deuce.transform.ExcludeInternal;

/**
 * @author Pascal Felber
 */
@ExcludeInternal
public class ReadFieldAccess {

	protected Object reference;
	protected long field;
	private int hash;
	private long lock;

	public ReadFieldAccess() { }

	public ReadFieldAccess(Object reference, long field, int hash, long lock) {
		init(reference, field, hash, lock);
	}

	public void init(Object reference, long field, int hash, long lock) {
		this.reference = reference;
		this.field = field;
		this.hash = hash;
		this.lock = lock;
	}

	public Object getReference() {
		return reference;
	}

	public long getField() {
		return field;
	}

	public int getHash() {
		return hash;
	}

	public long getLock() {
		return lock;
	}
}