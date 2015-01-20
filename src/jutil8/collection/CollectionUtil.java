/**
 * CollectionUtil.java
 *
 * Copyright (c) 2014 Yoshihiro Ito
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package jutil8.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import jutil8.comp.FindComparator;
import jutil8.comp.SumCalculator;

/**
 * コレクションや配列に対するユーティリティ
 */
public class CollectionUtil
{

	/**
	 * コレクションから指定条件の要素を検索しその要素を返す
	 * @param <T> ジェネリック型
	 * @param c 検索したいコレクション
	 * @param comp 検索条件
	 * @return 条件に合った最初の要素を返す。見つからなかったらnull
	 */
	public static <T> T find(Collection<T> c, FindComparator<T> comp)
	{
		for (T t : c)
		{
			if(comp.compare(t)) return t;
		}
		return null;
	}

	/**
	 * コレクションから指定条件に合う最後の要素を検索しその要素を返す
	 * @param <T> ジェネリック型
	 * @param c 検索したいコレクション
	 * @param comp 検索条件
	 * @return 条件に合った要素を返す。見つからなかったらnull
	 */
	public static <T> T findLast(Collection<T> c, FindComparator<T> comp)
	{
		T last = null;
		for (Iterator<T> iterator = c.iterator(); iterator.hasNext();)
		{
			T t = iterator.next();
			if(comp.compare(t)) last = t;
		}
		return last;
	}


	/**
	 * コレクションから指定条件に合ったすべての要素を検索し,ArrayListを返す
	 * @param <T> ジェネリック型
	 * @param c 検索したいコレクション
	 * @param comp 検索条件
	 * @return 条件に合ったすべての要素を含むArrayListを返す
	 */
	public static <T> ArrayList<T> findAll(Collection<T> c, FindComparator<T> comp)
	{
		ArrayList<T> list = new ArrayList<>(c.size());
		for (T t : c)
		{
			if(comp.compare(t)) list.add(t);
		}
		return list;
	}


	/**
	 * コレクションから指定条件の要素を検索し、その要素を返す
	 * @param <T> ジェネリック型
	 * @param c 検索したいコレクション
	 * @param comp 検索条件
	 * @return 条件に合った要素のインデックスを返す。見つからなかったら-1を返す
	 */
	public static <T> int indexOf(Collection<T> c, FindComparator<T> comp)
	{
		int idx = 0;
		for (Iterator<T> iterator = c.iterator(); iterator.hasNext();)
		{
			T t = iterator.next();
			if(comp.compare(t)) return idx;
			idx++;
		}
		return -1;
	}


	/**
	 * コレクションから指定条件の要素を検索し、その要素を返す
	 * @param <T> ジェネリック型
	 * @param c 検索したいコレクション
	 * @param comp 検索条件
	 * @return 条件に合った要素のインデックスを返す。見つからなかったら-1を返す
	 */
	public static <T> int lastIndexOf(Collection<T> c, FindComparator<T> comp)
	{
		int idx = 0;
		int last = -1;
		for (Iterator<T> iterator = c.iterator(); iterator.hasNext();)
		{
			T t = iterator.next();
			if(comp.compare(t)) last = idx;
			idx++;
		}
		return last;
	}


	/**
	 * コレクションから指定条件の要素があるかを調べる
	 * @param <T> ジェネリック型
	 * @param c 調べたいコレクション
	 * @param comp 検索条件
	 * @return 条件に合った要素が見つかったらtrue, 見つからなかったらfalse
	 */
	public static <T> boolean contains(Collection<T> c, FindComparator<T> comp)
	{
		for (T t : c)
		{
			if(comp.compare(t)) return true;
		}
		return false;
	}
	
	
	/**
	 * コレクションが指定条件を満たす要素をすべて含んでいるか
	 * @param <T> ジェネリック型
	 * @param c 調べたいコレクション
	 * @param comp 検索条件
	 * @return すべて含んでいたらtrue, １つでも含んでいなかったらfalse
	 */
	public static <T> boolean containsAll(Collection<T> c, FindComparator<T> comp)
	{
		for (T t : c)
		{
			if(!comp.compare(t)) return false;
		}
		return true;
	}


	/**
	 * コレクションから条件にあう要素の数を数える
	 * @param <T> ジェネリック型
	 * @param c 調べるコレクション
	 * @param comp 数える条件
	 * @return 条件に合った要素の数
	 */
	public static <T> int count(Collection<T> c, FindComparator<T> comp)
	{
		int count = 0;
		for (T t : c)
		{
			if(comp.compare(t)) count++;
		}
		return count;
	}


	/**
	 * コレクションの要素で加算関数を利用しその結果を返す
	 * @param <T> ジェネリック型
	 * @param c コレクション
	 * @param calc 加算関数
	 * @return すべての要素の加算結果
	 */
	public static <T> int sum(Collection<T> c, SumCalculator<T> calc)
	{
		int sum = 0;
		for (T t : c)
		{
			sum += calc.calc(t);
		}
		return sum;
	}

}
