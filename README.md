# Hua - Store

An e-commerce store designed by Hua, and just for fun using some java8 technology, solr, redis cluster, nginx.

#### Background:

E-commerce website is popular in nowadays market, especially in China. In order to make myself competent, I need to learn how to build a e-commerce website from scrach.

#### Agenda:

| DAYS | Agenda                                                       | Finished | Date                               |
| ---- | ------------------------------------------------------------ | -------- | ---------------------------------- |
| 1    | Background, history, now and future. Setup maven project, GitHub repo created. |          | 04/18/2018, 04/19/2018, 04/19/2018 |
| 2    | Framework intergration. Products list implemetation, paganation. |          |                                    |
| 3    | Backend service management. Add product, image upload.       |          |                                    |
| 4    | Product regulation?                                          |          |                                    |
| 5    | Product front end, display page.                             |          |                                    |
| 6    | cms implementation. Ad display.                              |          |                                    |
| 7**  | Add cache, Redis, cache synchornaztion.                      |          |                                    |
| 8*   | Search function. Implement by solr.                          |          |                                    |
| 9    | Product detail page.                                         |          |                                    |
| 10   | Shared session.                                              |          |                                    |
| 11   | Shopping cart.                                               |          |                                    |
| 12** | Nginx                                                        |          |                                    |
| 13   | Redis cluster, solr cluster. System deployment.              |          |                                    |
| 14   | Wrap up                                                      |          |                                    |

#### Features:

- Backend: Product mangement, order managerment, category management, user management, publisher
- Frontend: User can register, login, broswer products, homepage and place an order
- Membership: Order history, bookmarked product, coupon code and groupon
- Order: Place, search, modify and order scheduler
- Seach: Prodct search function

#### Tech Approach:

- Spring, SpringMVC, Mybatis
- JSP, JSTL, jQuery, plugin, EasyUI, KindEditor
- Rdis
- Solr
- httpClient
- Mysql
- Nginx

#### Development Environment

- IntelliJ
- Maven 3.3.9
- Tomcat 9.0.6
- JDK 1.8
- MySql 5.7.21
- Nginx
- Redis 3.2.11
- macOS High Sierra
- Github - https://github.com/lianghua1987/hua-store.git


#### Maven 

| Pom Files     | Extension |
| ------------- | --------- |
| store-parent  | .pom      |
| store-common  | .jar      |
| store-manager | .pom      |

#### Structure

store-parent

|— store-common

|— store-manager

​       |— com.hua.manager.web(.**war**)

​       |— com.hua.manager.service

​       |— com.hua.manager.mapper

​       |— com.hua.manager.pojo

#### Config

```
// under store-manager, pom.xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <configuration>
                    <port>8080</port>
                    <path>/</path>
                </configuration>
            </plugin>
        </plugins>
    </build>
```



#### Run

```
// under store-manager
mvn clean install
mvn clean tomcat7:run
```

