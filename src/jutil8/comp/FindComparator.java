/**
 * FindComparator.java
 *
 * Copyright (c) 2015 Yoshihiro Ito
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package jutil8.comp;

/**
 * コレクション検索の比較に使用するコンパレータ
 */
@FunctionalInterface
public interface FindComparator<T>
{
	/**
	 * 比較を行い、検索条件に一致するかを判断する
	 * @param obj 比較対象
	 * @return 一致する場合true, 一致しない場合false
	 */
	public abstract boolean compare(T obj);
}