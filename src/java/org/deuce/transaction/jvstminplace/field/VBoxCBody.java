/**
 * JVSTM Implementation
 * 
 * JVSTM is a multiversion STM for Java developed by Joao Cachopo 
 * from INESC-ID.
 * 
 * @author Ricardo Dias
 */
package org.deuce.transaction.jvstminplace.field;

import org.deuce.transform.ExcludeInternal;



@ExcludeInternal
public class VBoxCBody implements VBoxBody {

	public volatile int version;
	public VBoxCBody next;
	public volatile char value;

	public VBoxCBody(char value, int version, VBoxCBody next) {
		this.version = version;
		this.next = next;
		this.value = value;
	}

	public VBoxCBody getBody(int maxVersion) {
//		return ((version > maxVersion) ? next.getBody(maxVersion) : this);
		VBoxCBody res = this;
		while(res.version > maxVersion) { res = res.next; }
		return res;
	}

	public void clearPrevious() {
		this.next = null;
	}
}
