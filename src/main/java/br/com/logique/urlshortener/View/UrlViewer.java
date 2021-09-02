package br.com.logique.urlshortener.View;

import java.util.List;
import br.com.logique.urlshortener.Model.UrlModel;
import br.com.logique.urlshortener.Controller.UrlController;


public class UrlViewer {
	
	public List<UrlModel>getUrls(){
		List<UrlModel> urls = null;
		
		try {
			UrlController urlController = new UrlController();
			urls= urlController.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return urls;
	}
	
	public UrlModel getUrlByCode(String code){
		UrlModel url = null;
		
		try {
			UrlController urlController = new UrlController();
			url = urlController.getUrlByCode(code);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return url;
	}

}
