package org.deuce.transaction.jvstminplace.field;


import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class VBoxIBody implements VBoxBody {

	public volatile int version;
	public VBoxIBody next;
	public volatile int value;

	public VBoxIBody(int value, int version, VBoxIBody next) {
		this.version = version;
		this.next = next;
		this.value = value;
	}

	public VBoxIBody getBody(int maxVersion) {
//		return ((version > maxVersion) ? next.getBody(maxVersion) : this);
		VBoxIBody res = this;
		while(res.version > maxVersion) { res = res.next; }
		return res;
	}

	public void clearPrevious() {
		this.next = null;
	}
}
