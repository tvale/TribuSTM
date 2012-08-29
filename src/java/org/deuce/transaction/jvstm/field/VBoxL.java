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
public class VBoxL implements VBox {
	public VBoxLBody body = null;

	public VBoxL(long value) {
		body = new VBoxLBody(value, 0, null);
	}

	public boolean validate(VBoxBody body) {
		return this.body == body;
	}

	public VBoxBody commit(Value newValue, int txNumber) {
		VBoxLBody newBody = makeNewBody(newValue, txNumber, this.body);
		this.body = newBody;
		return newBody;
	}

	private static VBoxLBody makeNewBody(Value value, int version,
			VBoxLBody next) {
		return new VBoxLBody(((LongValue) value).value, version, next);
	}

	public VBoxBody getBody(int clock) {
		return body.getBody(clock);
	}

	public VBoxBody getTop() {
		return body;
	}
}
