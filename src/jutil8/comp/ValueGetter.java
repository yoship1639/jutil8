/**
 * ValueGetter.java
 *
 * Copyright (c) 2015 Yoshihiro Ito
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package jutil8.comp;

/**
 * オブジェクトの特定項目の値を返す機能
 */
@FunctionalInterface
public interface ValueGetter<T>
{
	/**
	 * objの特定項目の値を返す
	 * @param obj 対象のオブジェクト
	 * @return 特定項目の値
	 */
	public abstract int getValue(T obj);
}
