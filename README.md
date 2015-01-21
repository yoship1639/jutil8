# jutil8
java8の便利なクラスや関数をまとめます。  
ラムダ式、ジェネリックを多用し様々な場面で汎用的に使える機能を提供します。  
特定操作の無駄な記述を減らし、コードを綺麗にまとめることを目的とします。

## 機能
現在の利用可能な機能は以下の通りです。

### ArrayUtilクラス
配列処理における便利な関数をまとめたユーティリティクラスです。  
検索等による無駄な記述を吸収し、きれいにまとめます。  
ジェネリック型+ファンクションインタフェースによる条件指定のため  
汎用的な利用が可能です。  
* toArrayList - 配列をコレクションに変換
* find - 配列から指定条件に合う最初の要素を検索
* findLast - 配列から指定条件に合う最後の要素を検索
* findAll - 配列から指定条件に合ったすべての要素を検索
* indexOf - 配列から指定条件に合う最初の要素を検索しインデックスを返す
* lastIndexOf - 配列から指定条件に合う最後の要素を検索しインデックスを返す
* contains - 配列から指定条件の要素が含まれているか
* containsAll - 配列が指定条件を満たす要素をすべて含んでいるか
* count - 配列から条件にあう要素の数を数える
* max - 配列から特定要素の値が最も大きい要素を返す
* min - 配列から特定要素の値が最も小さい要素を返す
* sum - 配列の要素オブジェクトが持つ特定項目の合計を計算

#### サンプル
##### ・ people配列の中から身長180cm以上の人を見つける  
通常の検索

    Person tall = null;
    for ( Person p : people ) {
        if ( p.getStature() >= 180 ) {
            tall = p;
            break;
        }
    }
    
ArrayUtil.findによる検索

    Person tall = ArrayUtil.find(people, (p)->{ return p.getStature() >= 180; });

##### ・ people配列に含まれる人が持つ所持金の合計を数える
通常の計算

    int total = 0;
    for ( Person p : people ) {
        total += p.getMoney();
    }

ArrayUtil.sumによる計算

    int total = ArrayUtil.sum(people, (p)->{ return p.getMoney(); });
    
##### ・ people配列の中で最も所持金が多い人を見つける
通常の検索

    Person max = null;
    int maxValue = Integer.MIN_VALUE;
    for ( Person p : people ) {
        int value = p.getMoney();
        if ( value > maxValue ) {
            max = p;
            maxValue = value;
        }
    }
    
ArrayUtil.maxによる検索

    People max = ArrayUtil.max(people, (p)->{ return p.getMoney(); });

### CollectionUtilクラス
コレクション処理(ArrayList等)における便利な関数をまとめたユーティリティクラスです。  
ArrayUtilクラスとほぼ同等の機能を有します。  


