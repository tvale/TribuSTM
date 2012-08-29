/*
 * JVSTM: a Java library for Software Transactional Memory
 * Copyright (C) 2005 INESC-ID Software Engineering Group
 * http://www.esw.inesc-id.pt
 *
 * Author's contact:
 * INESC-ID Software Engineering Group
 * Rua Alves Redol 9
 * 1000 - 029 Lisboa
 * Portugal
 */
package org.deuce.transaction.jvstm;

import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class Pair<E1,E2> {
    public E1 first;
    public E2 second;

    public Pair() {
    }

    public Pair(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object other) {
        if ((other != null) && (other.getClass() == this.getClass())) {
            Pair<?,?> p2 = (Pair)other;
            return eq(this.first, p2.first) && eq(this.second, p2.second);
        }
        return false;
    }

    private static boolean eq(Object o1, Object o2) {
        return ((o1 == o2) || ((o1 != null) && o1.equals(o2)));
    }
}
