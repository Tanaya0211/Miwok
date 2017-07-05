package com.example.android.miwok;

/**
 * Created by SANKET on 2/4/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId;
    private int maudioResourceId;
    private static final int NO_IMAGE_PROVIDED=-1;

    public Word(String DefaultTrnaslation,String MiwokTranslation,int audioResourceId){
        mDefaultTranslation=DefaultTrnaslation;
        mMiwokTranslation=MiwokTranslation;
        maudioResourceId=audioResourceId;
    }
    public Word(String DefaultTrnaslation,String MiwokTranslation,int ImageResourceId,int audioResourceId){
        mDefaultTranslation=DefaultTrnaslation;
        mMiwokTranslation=MiwokTranslation;
        mImageResourceId=ImageResourceId;
        maudioResourceId=audioResourceId;
    }



    public String getDefaultTranslation(){
        return mDefaultTranslation;

    }
    public String getMiwokTranslation()    {
        return mMiwokTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public int getaudioResourceId(){return maudioResourceId;}
    public Boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
