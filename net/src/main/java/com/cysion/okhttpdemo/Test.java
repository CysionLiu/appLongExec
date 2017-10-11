package com.cysion.okhttpdemo;

import android.support.annotation.NonNull;

/**
 * Created by Cysion Liu on 2017/8/16.
 */

public class Test {
    class A{

    }
    class B{

    }
    class C extends A{

    }
    class D{

    }
    class E implements Comparable<C>{

        @Override
        public int compareTo(@NonNull C o) {
            return 0;
        }
    }

    public void cc(Comparable<? extends A> x){
        xx(x);
    }
    public void xx(Comparable aDComparable){
        aDComparable.compareTo(new A());
        cc(new E());
    }


}
