package org.deuce.transaction.tl2cm.field;

import org.deuce.transform.ExcludeInternal;

/**
 * Represents a base class for field write access. Based on Guy Korland's work on <code>org.deuce.transaction.tl2.*</code>
 * 
 * @author Yoav Cohen, yoav.cohen@cs.tau.ac.il
 */
@ExcludeInternal
abstract public class WriteFieldAccess extends ReadFieldAccess{

	/**
	 * Commits the value in memory.
	 */
	abstract public void put();
}
