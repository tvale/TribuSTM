/**
 * JVSTM Implementation
 * 
 * JVSTM is a multiversion STM for Java developed by Joao Cachopo 
 * from INESC-ID.
 * 
 * @author Ricardo Dias
 */
package org.deuce.transaction.jvstm.field;


import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class VBoxLBody implements VBoxBody {

	public volatile int version;
	public VBoxLBody next;
	public volatile long value;

	public VBoxLBody(long value, int version, VBoxLBody next) {
		this.version = version;
		this.next = next;
		this.value = value;
	}

	public VBoxLBody getBody(int maxVersion) {
//		return ((version > maxVersion) ? next.getBody(maxVersion) : this);
		VBoxLBody res = this;
		while(res.version > maxVersion) { res = res.next; }
		return res;
	}

	public void clearPrevious() {
		this.next = null;
	}
}
