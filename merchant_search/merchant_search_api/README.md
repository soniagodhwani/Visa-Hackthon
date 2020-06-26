# Merchant Search API
Search for merchant identification data using the acquirer provide name and card acceptor identifiers
## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute the following in the base directory:

```shell
mvn install
```

To run all the test cases, follow these steps:
- Set the following credentials in the **MerchantSearchApiTest.java** file. *Refer to the [Getting started](https://developer.visa.com/pages/working-with-visa-apis/create-project) to create an app for credentials.*

```
    public MerchantSearchApiTest(){
        // Configure HTTP basic authorization: basicAuth
        apiClient.setUsername("YOUR USERNAME");
        apiClient.setPassword("YOUR PASSWORD");
        apiClient.setKeystorePath("YOUR KEYSTORE PATH");
        apiClient.setKeystorePassword("YOUR KEYSTORE PASSWORD");
        apiClient.setPrivateKeyPassword("YOUR PRIVATEKEY PASSWORD");
        
        // To set proxy uncomment the below lines
        // apiClient.setProxyHostName("proxy.address@example.com");
        // apiClient.setProxyPortNumber(0000);
        api = new MerchantSearchApi(apiClient);
    }

```
- Now simply execute the following in the base directory:

```shell
mvn test
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute the following in the base directory:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.visa</groupId>
    <artifactId>merchant_search_api</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/merchant_search_api-1.0.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.visa.developer.sample.merchant_search_api.*;
import com.visa.developer.sample.merchant_search_api.auth.*;
import com.visa.developer.sample.merchant_search_api.model.*;
import com.visa.developer.sample.merchant_search_api.api.MerchantSearchApi;

import java.io.File;
import java.util.*;

public class MerchantSearchApiExample {

    public static void main(String[] args) {

        ApiClient apiClient = new ApiClient();

        // Configure HTTP basic authorization: basicAuth
        apiClient.setUsername("YOUR USERNAME");
        apiClient.setPassword("YOUR PASSWORD");
        apiClient.setKeystorePath("YOUR KEYSTORE PATH");
        apiClient.setKeystorePassword("YOUR KEYSTORE PASSWORD");
        apiClient.setPrivateKeyPassword("YOUR PRIVATEKEY PASSWORD");
        
        // To set proxy uncomment the below lines
        // apiClient.setProxyHostName("proxy.address@example.com");
        // apiClient.setProxyPortNumber(0000);

        MerchantSearchApi apiInstance = new MerchantSearchApi(apiClient);
        
        MerchantSearchpostPayload body = new MerchantSearchpostPayload(); // Set all the required parameters. Refer to the model documentation below for further information
        
        try {
            MerchantSearchpostResponse result = apiInstance.postmerchantSearch(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MerchantSearchApi#postmerchantSearch");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://sandbox.api.visa.com/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MerchantSearchApi* | [**postmerchantSearch**](docs/MerchantSearchApi.md#postmerchantSearch) | **POST** /merchantsearch/v1/search | 


## Documentation for Models

 - [EncryptedResponse](docs/EncryptedResponse.md)
 - [Header](docs/Header.md)
 - [MerchantSearchpostPayload](docs/MerchantSearchpostPayload.md)
 - [MerchantSearchpostResponse](docs/MerchantSearchpostResponse.md)
 - [Response](docs/Response.md)
 - [ResponseHeader](docs/ResponseHeader.md)
 - [ResponseValues](docs/ResponseValues.md)
 - [SearchAttrList](docs/SearchAttrList.md)
 - [SearchOptions](docs/SearchOptions.md)
 - [Status](docs/Status.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### basicAuth


- **Type**: HTTP basic authentication





## Author
**Visa Developer Platform**
See also the list of [contributors](https://github.com/visa/java-sample-code/graphs/contributors) who participated in this project.


##License
**© Copyright 2018 Visa. All Rights Reserved.**

*NOTICE: The software and accompanying information and documentation (together, the “Software”) remain the property of
and are proprietary to Visa and its suppliers and affiliates. The Software remains protected by intellectual property
rights and may be covered by U.S. and foreign patents or patent applications. The Software is licensed and not sold.*

*By accessing the Software you are agreeing to Visa's terms of use (developer.visa.com/terms) and privacy policy (developer.visa.com/privacy).
In addition, all permissible uses of the Software must be in support of Visa products, programs and services provided
through the Visa Developer Program (VDP) platform only (developer.visa.com). **THE SOFTWARE AND ANY ASSOCIATED
INFORMATION OR DOCUMENTATION IS PROVIDED ON AN “AS IS,” “AS AVAILABLE,” “WITH ALL FAULTS” BASIS WITHOUT WARRANTY OR
CONDITION OF ANY KIND. YOUR USE IS AT YOUR OWN RISK.** All brand names are the property of their respective owners, used for identification purposes only, and do not imply
product endorsement or affiliation with Visa. Any links to third party sites are for your information only and equally
do not constitute a Visa endorsement. Visa has no insight into and control over third party content and code and disclaims
all liability for any such components, including continued availability and functionality. Benefits depend on implementation
details and business factors and coding steps shown are exemplary only and do not reflect all necessary elements for the
described capabilities. Capabilities and features are subject to Visa’s terms and conditions and may require development,
implementation and resources by you based on your business and operational details. Please refer to the specific
API documentation for details on the requirements, eligibility and geographic availability.*

*This Software includes programs, concepts and details under continuing development by Visa. Any Visa features,
functionality, implementation, branding, and schedules may be amended, updated or canceled at Visa’s discretion.
The timing of widespread availability of programs and functionality is also subject to a number of factors outside Visa’s control,
including but not limited to deployment of necessary infrastructure by issuers, acquirers, merchants and mobile device manufacturers.*