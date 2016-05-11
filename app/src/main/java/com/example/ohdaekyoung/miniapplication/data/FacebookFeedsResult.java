package com.example.ohdaekyoung.miniapplication.data;

import java.util.List;

/**
 * Created by Tacademy on 2016-05-11.
 */
public class FacebookFeedsResult {
    public List<FacebookFeed> data;
    public void convertStringToDate() {
        for (FacebookFeed ff : data) {
            ff.changeStringToDate();
        }
    }
}
