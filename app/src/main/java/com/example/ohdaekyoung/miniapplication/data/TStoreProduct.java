package com.example.ohdaekyoung.miniapplication.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OhDaeKyoung on 2016. 5. 9..
 */
public class TStoreProduct {
    String categoryPath;
    String webUrl;
    int charge;
    int downloadCount;
    String description;
    String thumbnailUrl;
    String name;
    float score;
    String tinyUrl;
    String detailDescription;
    String productId;
    String platfrom;
    String developerId;
    String osVersion;
    String categoryCode;
    @SerializedName("previewUrl")
    String rawPreviewUrls;
    List<String> previewUrlList=new ArrayList<>();
    public  boolean makePreviewUrlList(){
        if(rawPreviewUrls!=null)
        {
            String[] urls=rawPreviewUrls.split(";");
            previewUrlList.addAll(Arrays.asList(urls)); //문자열 잘린걸 리스트ㅗ 만들어 넣는다
            return true;
        }
        return false;
    }
    int voterCount;
    TStorePhoneModels models;
    String categoryName;
    String developerName;

    public String getPlatfrom() {
        return platfrom;
    }

    public void setPlatfrom(String platfrom) {
        this.platfrom = platfrom;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getRawPreviewUrls() {
        return rawPreviewUrls;
    }

    public void setRawPreviewUrls(String rawPreviewUrls) {
        this.rawPreviewUrls = rawPreviewUrls;
    }

    public int getVoterCount() {
        return voterCount;
    }

    public void setVoterCount(int voterCount) {
        this.voterCount = voterCount;
    }

    public List<String> getPreviewUrlList() {
        return previewUrlList;
    }

    public void setPreviewUrlList(List<String> previewUrlList) {
        this.previewUrlList = previewUrlList;
    }

    public TStorePhoneModels getModels() {
        return models;

    }

    public void setModels(TStorePhoneModels models) {
        this.models = models;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
