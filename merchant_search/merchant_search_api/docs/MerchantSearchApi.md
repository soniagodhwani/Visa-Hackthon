#MerchantSearchApi
Search for merchant identification data using the acquirer provide name and card acceptor identifiers

All URIs are relative to *https://sandbox.api.visa.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**postmerchantSearch**](MerchantSearchApi.md#postmerchantSearch) | **POST** /merchantsearch/v1/search | 




<a name="postmerchantSearch"></a>
#**postmerchantSearch**
> MerchantSearchpostResponse postmerchantSearch(body)



### Example
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

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MerchantSearchpostPayload**](MerchantSearchpostPayload.md)|  |


### Return type

[**MerchantSearchpostResponse**](MerchantSearchpostResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json





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