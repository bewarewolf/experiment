package com.quantil.auth;

public enum APICredentials {

	QA(
            "http://api-qa.mileweb.com",
            "mwtest1",
            "8768a2474dac4a7a"),
            
    QA2(
            "http://api-qa2.mileweb.com",
            "mwtest1",
            "8768a2474dac4a7a"),

    STAGING(
            "http://api-staging.mileweb.com",
            "nixqa", 
            "qvCotk/dzskC7QBh2af+zxRf%W7&8X"),

    HDT(
            "https://qa_hdt.mileweb.com",
            "testforhdt",
            "dcR/zwb/riaamJkG_h4BHoCZ+95au2"),

    UnsubscribedUserHDT(
            "https://qa_hdt.mileweb.com",
            "apiQA",
            "ajKNq@B13b%nC!m.UogaZo2sgVw5rn"
            ),

    PRODUCTION(
            "http://api.quantil.com",
            "nixQA4", 
            "d=7w1&kGdAepL6A&HfvVbkbtp1&wiX");



    private String endpoint;
    private String user;
    private String key;
    
    APICredentials(String endpoint, String user, String key) {
        this.user = user;
        this.key = key;
        this.endpoint = endpoint;
    }

	public String getEndpoint() {
		return endpoint;
	}

	public String getUser() {
		return user;
	}

	public String getKey() {
		return key;
	}    
}
