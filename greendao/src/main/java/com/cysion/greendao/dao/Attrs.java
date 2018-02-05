package com.cysion.greendao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017\12\18 0018.
 */
@Entity
public class Attrs {
    @Id
    private long id;
    private String name;
    private String value;
    @Generated(hash = 1691208677)
    public Attrs(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
    @Generated(hash = 833843412)
    public Attrs() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
