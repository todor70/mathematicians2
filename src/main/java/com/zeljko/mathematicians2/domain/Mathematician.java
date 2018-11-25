package com.zeljko.mathematicians2.domain;

public class Mathematician {

    private int mathematicianID;
    private String name;
    private String lived;
    private String image;
    private String text;

    public Mathematician() {
    }

    public int getMathematicianID() {
        return mathematicianID;
    }

    public void setMathematicianID(int mathematicianID) {
        this.mathematicianID = mathematicianID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLived() {
        return lived;
    }

    public void setLived(String lived) {
        this.lived = lived;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Mathematician{" +
                "mathematicianID=" + mathematicianID +
                ", name='" + name + '\'' +
                ", lived='" + lived + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}


