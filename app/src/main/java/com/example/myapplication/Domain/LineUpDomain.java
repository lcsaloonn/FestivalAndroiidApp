package com.example.myapplication.Domain;

import java.io.Serializable;

public class LineUpDomain implements Serializable {
    private String name;
    private String pic;

    public LineUpDomain(String name, String pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
}
