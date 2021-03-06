package org.deuce.transaction.tl2cm.field;

import org.deuce.reflection.UnsafeHolder;
import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class LongWriteFieldAccess extends WriteFieldAccess {

	private long value;

	public void set(long value, Object reference, long field) {
		super.init(reference, field);
		this.value = value;
	}

	@Override
	public void put() {
		UnsafeHolder.getUnsafe().putLong(reference, field, value);
		clear();
	}

	public long getValue() {
		return value;
	}

}
