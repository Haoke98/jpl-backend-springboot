package bupt.edu.cn.BeautifulJapanese.utils.entryptor;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encryptor {
    private BasicTextEncryptor encryptor;
    private String SALT;

    public Encryptor(String SALT) {
        this.SALT = SALT;
        this.encryptor = new BasicTextEncryptor();
        this.encryptor.setPassword(SALT);
    }

    public void encrypt(String targetPassword) {
        System.out.println(targetPassword + ":" + "ENC(" + this.encryptor.encrypt(targetPassword) + ")");
    }


    public void mysql(String host, Integer port, String database, String username, String password, Boolean characterEncodingUTF8) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
        if (characterEncodingUTF8) {
            url += "?characterEncoding=utf8";
        }
        System.out.println("----------------------------Before Encrypted---------------------------------");
        System.out.println("spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver");
        System.out.println("spring.datasource.url=" + url);
        System.out.println("spring.datasource.username=" + username);
        System.out.println("spring.datasource.password=" + password);
        System.out.println("spring.jpa.database=mysql");
        System.out.println("spring.jpa.show-sql=true");
        System.out.println("spring.jpa.hibernate.ddl-auto=update");
        System.out.println("spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        System.out.println("spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect");

        System.out.println("----------------------------Aftere Encrypted---------------------------------");
        System.out.println("jasypt.encryptor.password=" + SALT);
        System.out.println("spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver");
        System.out.println("spring.datasource.url=ENC(" + encryptor.encrypt(url) + ")");
        System.out.println("spring.datasource.username=ENC(" + encryptor.encrypt(username) + ")");
        System.out.println("spring.datasource.password=ENC(" + encryptor.encrypt(password) + ")");
        System.out.println("spring.jpa.database=mysql");
        System.out.println("spring.jpa.show-sql=true");
        System.out.println("spring.jpa.hibernate.ddl-auto=update");
        System.out.println("spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        System.out.println("spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect");
    }


    public void elasticSearch(String host, Integer port, String username, String password) {
        String uri = "http://" + host + ":" + port;
        System.out.println("----------------------------Before Encrypted---------------------------------");
        System.out.println("spring.data.elasticsearch.repositories.enabled=true");
        System.out.println("spring.elasticsearch.rest.uris=" + uri);
        System.out.println("spring.elasticsearch.rest.username=" + username);
        System.out.println("spring.elasticsearch.rest.password=" + password);
        System.out.println("----------------------------Aftere Encrypted---------------------------------");
        System.out.println("jasypt.encryptor.password=" + SALT);
        System.out.println("spring.data.elasticsearch.repositories.enabled=true");
        System.out.println("spring.elasticsearch.rest.uris=ENC(" + encryptor.encrypt(uri) + ")");
        System.out.println("spring.elasticsearch.rest.username=ENC(" + encryptor.encrypt(username) + ")");
        System.out.println("spring.elasticsearch.rest.password=ENC(" + encryptor.encrypt(password) + ")");
    }
}

