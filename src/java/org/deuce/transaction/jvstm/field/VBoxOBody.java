package org.deuce.transaction.jvstm.field;


import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class VBoxOBody implements VBoxBody {

	public volatile int version;
	public VBoxOBody next;
	public volatile Object value;

	public VBoxOBody(Object value, int version, VBoxOBody next) {
		this.version = version;
		this.next = next;
		this.value = value;
	}

	public VBoxOBody getBody(int maxVersion) {
//		return ((version > maxVersion) ? next.getBody(maxVersion) : this);
		VBoxOBody res = this;
		while(res.version > maxVersion) { res = res.next; }
		return res;
	}

	public void clearPrevious() {
		this.next = null;
	}
}