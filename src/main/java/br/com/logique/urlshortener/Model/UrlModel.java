package br.com.logique.urlshortener.Model;

public class UrlModel {
private int id;
private String url;
private String code;
private String insert_date;
private String custom;


public UrlModel(){
	
}
public UrlModel(int id, String url, String code,String insert_date, String custom){
	this.id = id;
	this.url = url;
	this.code = code;
	this.code = insert_date;
	this.custom = custom;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getInsert_date() {
	return insert_date;
}
public void setInsert_date(String insert_date) {
	this.insert_date = insert_date;
}
public String getCustom() {
	return custom;
}
public void setCustom(String custom) {
	this.custom = custom;
}


}
