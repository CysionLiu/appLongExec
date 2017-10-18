package com.cysion.simple;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Cysion Liu on 2017/10/18.
 */

public class Book implements Parcelable {

    private String bookName;
    private int pages;

    public Book(String aBookName, int aPages) {
        bookName = aBookName;
        pages = aPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String aBookName) {
        bookName = aBookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int aPages) {
        pages = aPages;
    }

    protected Book(Parcel in) {
        bookName = in.readString();
        pages = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeInt(pages);
    }

    @Override
    public String toString() {
        return "bookname="+bookName+"&pages="+pages;
    }
}
