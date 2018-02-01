package com.smart_museum.client;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.smart_museum.entity.Evidence;
import com.smart_museum.entity.Museum;
import com.smart_museum.entity.Operator;

public class RestClientUtil {
    public Museum getMuseumByIdDemo(int museumId) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/museum/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Museum> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Museum.class, museumId);
        Museum museum = responseEntity.getBody();
        return museum;
    }
    public Operator getOperatorByIdDemo(int id) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/operator/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Operator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Operator.class, id);
        Operator operator= responseEntity.getBody();
        return operator;
    }
	public void addEvidenceDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/evidence";
	    Evidence obj= new Evidence();
	    obj.setTitle("Un'opera fantastica");
	    obj.setAuthor("Mia madre");
	    obj.setDescription("Che opera!");
	    obj.setCreationDate(new Date());
	    obj.setMuseum(getMuseumByIdDemo(1));
	    obj.setOperator(getOperatorByIdDemo(1));
	    HttpEntity<Evidence> requestEntity = new HttpEntity<Evidence>(obj, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void addMuseumDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/museum";
	    Museum objMuseum = new Museum();
	    objMuseum.setName("Super Museo");
	    objMuseum.setAddress("Via Poro poro");
	    objMuseum.setEmail("supermuseo@gmail.com");
	    objMuseum.setLocation("Lecce");
	    objMuseum.setPostalNo(73100);
	    objMuseum.setDescription("Il museo di superman");
        HttpEntity<Museum> requestEntity = new HttpEntity<Museum>(objMuseum, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void addOperatorDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/operator";
	    Operator operator = new Operator();
	    operator.setAdmin(true);
	    operator.setEmail("sim.colaci@gmail.com");
	    operator.setName("Simone");
	    operator.setSurname("Colaci");
	    operator.setPassword("popo");
	    operator.setUsername("spronghi");
	    operator.setMuseum(getMuseumByIdDemo(1));
        HttpEntity<Operator> requestEntity = new HttpEntity<Operator>(operator, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    /*
	public void getAllArticlesDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/articles";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Article[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Article[].class);
        Article[] articles = responseEntity.getBody();
        for(Article article : articles) {
              System.out.println("Id:"+article.getArticleId()+", Title:"+article.getTitle()
                      +", Category: "+article.getCategory());
        }
    }
    public void addArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
	    Article objArticle = new Article();
	    objArticle.setTitle("Spring REST Security using Hibernate");
	    objArticle.setCategory("Spring");
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article";
	    Article objArticle = new Article();
	    objArticle.setArticleId(1);
	    objArticle.setTitle("Update:Java Concurrency");
	    objArticle.setCategory("Java");
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/article/{id}";
        HttpEntity<Article> requestEntity = new HttpEntity<Article>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    */
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
    	util.addMuseumDemo();
    	util.addOperatorDemo();
    	util.addEvidenceDemo();
    }    
}
