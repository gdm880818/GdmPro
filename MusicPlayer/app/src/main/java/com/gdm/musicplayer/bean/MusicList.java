package com.gdm.musicplayer.bean;


import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/12 0012.
 * fragment_my
 */
public class MusicList {
    private int imgPath;
    private String title;
    private String num;
    private Class mClass;
    private int type;//头部为0 内容为1
    private ArrayList<Music> m;

    public ArrayList<Music> getM() {
        return m;
    }

    public void setM(ArrayList<Music> m) {
        this.m = m;
    }

    public void setmClass(Class mClass) {
        this.mClass = mClass;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public Class getmClass() {
        return mClass;
    }
    public int getImgPath() {
            return imgPath;
        }

    public void setImgPath(int imgPath) {
            this.imgPath = imgPath;
        }

    public String getNum() {
            return num;
        }

    public void setNum(String num) {
            this.num = num;
        }

    public String getTitle() {
            return title;
        }

    public void setTitle(String title) {
            this.title = title;
        }

    @Override
    public String toString() {
        return "MusicList{" +
                "imgPath=" + imgPath +
                ", title='" + title + '\'' +
                ", num='" + num + '\'' +
                ", mClass=" + mClass +
                ", type=" + type +
                ", m=" + m +
                '}';
    }
}
