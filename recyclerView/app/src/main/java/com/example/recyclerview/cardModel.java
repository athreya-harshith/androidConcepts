package com.example.recyclerview;

public class cardModel
{
    int img;
    String cardTxt,cardTxtDesc;



    public cardModel(int img, String cardTxt, String cardTxtDesc)
    {
        this.img = img;
        this.cardTxt = cardTxt;
        this.cardTxtDesc = cardTxtDesc;
    }

    public cardModel(String cardTxt,String cardTxtDesc)
    {
        this.cardTxt=cardTxt;
        this.cardTxtDesc=cardTxtDesc;
    }
}
