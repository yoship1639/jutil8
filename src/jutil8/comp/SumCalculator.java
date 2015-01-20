/**
 * SumComparator.java
 *
 * Copyright (c) 2015 Yoshihiro Ito
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package jutil8.comp;

/**
 * コレクションや配列の加算のに用いるカリキュレータ
 */
@FunctionalInterface
public interface SumCalculator<T>
{
	/**
	 * オブジェクトの指定要素の数を返す
	 * @param obj 調べるオブジェクト
	 * @return 指定要素の数
	 */
	public abstract int calc(T obj);
}
