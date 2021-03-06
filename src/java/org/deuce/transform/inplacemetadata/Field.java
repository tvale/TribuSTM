/**
 * Contains a field information.
 * 
 * @author Guy Korland, Ricardo Dias <ricardo.dias@campus.fct.unl.pt>
 * @since 1.0
 */
package org.deuce.transform.inplacemetadata;

import org.deuce.objectweb.asm.Type;
import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class Field {
	private final String fieldNameAddress;
	private final String fieldName;
	private final int access;
	private final Type type;

	public Field(String fieldName, String fieldNameAddress, int access, Type type) {
		this.fieldName = fieldName;
		this.fieldNameAddress = fieldNameAddress;
		this.access = access;
		this.type = type;
	}

	public String getFieldNameAddress() {
		return fieldNameAddress;
	}

	public String getFieldName() {
		return fieldName;
	}

	public int getAccess() {
		return access;
	}

	public Type getType() {
		return type;
	}
}