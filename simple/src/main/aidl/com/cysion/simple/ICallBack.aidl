// ICallBack.aidl
package com.cysion.simple;
import com.cysion.simple.Book;
// Declare any non-default types here with import statements

interface ICallBack {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void notify(in Book book);
}
