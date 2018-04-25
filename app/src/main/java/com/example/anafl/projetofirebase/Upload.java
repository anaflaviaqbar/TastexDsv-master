package com.example.anafl.projetofirebase;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload(){

    }
    public Upload(String name, String imagemUrl){

        if(name.trim().equals("")){
            name = "No Name";
        }
        mName = name;
        mImageUrl = imagemUrl;
    }
    public String getmName(){
        return mName;
    }
    public void setmName (String name){
        mName = name;
    }
    public String getmImageUrl(){
        return mImageUrl;
    }
    public void setmImagemUrl(String imageUrl){
        mImageUrl = imageUrl;
    }

}
