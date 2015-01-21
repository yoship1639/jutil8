/**
 * ArrayUtil.java
 *
 * Copyright (c) 2015 Yoshihiro Ito
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package jutil8.array;

import java.util.ArrayList;

import jutil8.comp.*;

/**
 * 配列処理における便利な関数をまとめたユーティリティクラス
 */
public class ArrayUtil
{

	/**
	 * 配列からArrayListを作成する
	 * @param <T> ジェネリック型
	 * @param array ArrayListにしたい配列
	 * @return 作成したArrayList
	 */
	public static <T> ArrayList<T> toArrayList(T[] array)
	{
		ArrayList<T> c = new ArrayList<T>();
		for (T t : array)
		{
			c.add(t);
		}
		return c;
	}
	
	/**
	 * 配列から指定条件の要素を検索しその要素を返す
	 * @param <T> ジェネリック型
	 * @param array 検索する配列
	 * @param comp 検索条件
	 * @return 条件に合った最初の要素を返す。見つからなかったらnull
	 */
	public static <T> T find(T[] array, FindComparator<T> comp)
	{
		for (T t : array)
		{
			if (comp.compare(t)) return t;
		}
		return null;
	}
	
	/**
	 * 配列から指定条件に合う最後の要素を検索しその要素を返す
	 * @param <T> ジェネリック型
	 * @param array 検索する配列
	 * @param comp 検索条件
	 * @return 条件に合った要素を返す。見つからなかったらnull
	 */
	public static <T> T findLast(T[] array, FindComparator<T> comp)
	{
		for (int i=array.length; i >= 0; i--)
		{
			if (comp.compare(array[i])) return array[i];
		}
		return null;
	}
	
	/**
	 * 配列から指定条件に合ったすべての要素を検索し、ArrayListを返す
	 * @param <T> ジェネリック型
	 * @param array 検索する配列
	 * @param comp 検索条件
	 * @return 条件に合ったすべての要素をすべて含むArrayListを返す
	 */
	public static <T> ArrayList<T> findAll(T[] array, FindComparator<T> comp)
	{
		ArrayList<T> list = new ArrayList<>(array.length);
		for (T t : array)
		{
			if (comp.compare(t)) list.add(t);
		}
		return list;
	}
	
	/**
	 * 配列から指定条件の要素を検索し、その要素を返す
	 * @param <T> ジェネリック型
	 * @param array 検索する配列
	 * @param comp 検索条件
	 * @return 条件に合った要素のインデックスを返す。見つからなかったら-1を返す
	 */
	public static <T> int indexOf(T[] array, FindComparator<T> comp)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (comp.compare(array[i])) return i;
		}
		return -1;
	}
	
	/**
	 * 配列から指定条件の要素を検索し、その要素を返す
	 * @param <T> ジェネリック型
	 * @param array 検索する配列
	 * @param comp 検索条件
	 * @return 条件に合った要素のインデックスを返す。見つからなかったら-1を返す
	 */
	public static <T> int lastIndexOf(T[] array, FindComparator<T> comp)
	{
		for (int i=array.length; i >= 0; i--)
		{
			if(comp.compare(array[i])) return i;
		}
		return -1;
	}
	
	/**
	 * 配列から指定条件の要素があるかを調べる
	 * @param <T> ジェネリック型
	 * @param array 調べる配列
	 * @param comp 検索条件
	 * @return 条件に合った要素が見つかったらtrue, 見つからなかったらfalse
	 */
	public static <T> boolean contains(T[] array, FindComparator<T> comp)
	{
		for (T t : array)
		{
			if(comp.compare(t)) return true;
		}
		return false;
	}
	
	/**
	 * 配列が指定条件を満たす要素をすべて含んでいるか
	 * @param <T> ジェネリック型
	 * @param array 調べる配列
	 * @param comp 検索条件
	 * @return すべて含んでいたらtrue, １つでも含んでいなかったらfalse
	 */
	public static <T> boolean containsAll(T[] array, FindComparator<T> comp)
	{
		for (T t : array)
		{
			if(!comp.compare(t)) return false;
		}
		return true;
	}
	
	/**
	 * 配列から条件にあう要素の数を数える
	 * @param <T> ジェネリック型
	 * @param array 調べる配列
	 * @param comp 数える条件
	 * @return 条件に合った要素の数
	 */
	public static <T> int count(T[] array, FindComparator<T> comp)
	{
		int count = 0;
		for (T t : array)
		{
			if(comp.compare(t)) count++;
		}
		return count;
	}
	
	/**
	 * 配列から特定要素の値が最も大きい要素を返す
	 * @param <T> ジェネリック型
	 * @param array 調べる配列
	 * @param getter 値を返すゲッター
	 * @return 特定要素の値が最も大きい要素
	 */
	public static <T> T max(T[] array, ValueGetter<T> getter)
	{
		T max = null;
		int maxValue = Integer.MIN_VALUE;
		for (T t : array)
		{
			int value = getter.getValue(t);
			if (value > maxValue)
			{
				max = t;
				maxValue = value;
			}
		}
		return max;
	}
	
	/**
	 * 配列から特定要素の値が最も小さい要素を返す
	 * @param <T> ジェネリック型
	 * @param array 調べる配列
	 * @param getter 値を返すゲッター
	 * @return 特定要素の値が最も大きい要素
	 */
	public static <T> T min(T[] array, ValueGetter<T> getter)
	{
		T min = null;
		int minValue = Integer.MAX_VALUE;
		for (T t : array)
		{
			int value = getter.getValue(t);
			if (value < minValue)
			{
				min = t;
				minValue = value;
			}
		}
		return min;
	}
	
	
	/**
	 * 配列の要素で加算関数を利用しその結果を返す
	 * @param <T> ジェネリック型
	 * @param array 配列
	 * @param calc 加算関数
	 * @return すべての要素の加算結果
	 */
	public static <T> int sum(T[] array, SumCalculator<T> calc)
	{
		int sum = 0;
		for (T t : array)
		{
			sum += calc.calc(t);
		}
		return sum;
	}
}
