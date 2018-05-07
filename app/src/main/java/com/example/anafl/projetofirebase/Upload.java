package com.example.anafl.projetofirebase;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mIdPrato;

    public Upload(){

    }
    public Upload(String name, String imagemUrl, String idPrato){

        if(name.trim().equals("")){
            name = "No Name";
        }
        mName = name;
        mImageUrl = imagemUrl;
        mIdPrato = idPrato;

    }

    public Upload( String imagemUrl, String idPrato){


        mName = "No name";
        mImageUrl = imagemUrl;
        mIdPrato = idPrato;

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

    public String getmIdPrato() {
        return mIdPrato;
    }

    public void setmIdPrato(String mIdPrato) {
        this.mIdPrato = mIdPrato;
    }
}
