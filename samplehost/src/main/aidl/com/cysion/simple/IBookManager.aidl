// IBookManager.aidl
// IBookManager.aidl
package com.cysion.simple;
import com.cysion.simple.Book;
import com.cysion.simple.ICallBack;
// Declare any non-default types here with import statements

interface IBookManager {

   void addBook(in Book book);
   List<Book> getBooks();
   void register(ICallBack callback,int callId);
   void unRegister(int callId);
}
