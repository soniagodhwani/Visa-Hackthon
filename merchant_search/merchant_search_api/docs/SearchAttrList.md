
# SearchAttrList

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchantCity** | **String** | City of the registered Merchant | 
**merchantStreetAddress** | **String** | Address of the registered Merchant | 
**merchantName** | **String** | Name of the Merchant or Supplier. Note: Optional when any one of VisaMerchantId or VisaStoreId or BusinessRegistrationId or MerchantUrl or AcquirerCardAcceptorId is provided. | 
**merchantState** | **String** | State of the registered Merchant. Ex: US | 
**visaMerchantId** | **Double** | Unique identifier for Merchant provided by VISA. Note: Optional when any one of MerchantName or VisaStoreId or BusinessRegistrationId or MerchantUrl or AcquirerCardAcceptorId is provided. | 
**acquiringBin** | **Integer** | Acquirer Bin number. Required when AcquirerCardAcceptorId is provided | 
**merchantUrl** | **String** | URL of the registered Merchant which provides information about the Merchant. Note: Optional when any one of MerchantName or VisaMerchantId or VisaStoreId or BusinessRegistrationId or AcquirerCardAcceptorId is provided. | 
**merchantPhoneNumber** | **Double** | Phone number of the registered Merchant. MerchantPhoneNumber is optional field with VisaMerchantId, VisaStoreId, BusinessRegistrationId, MerchantUrl, MerchantName, AcquirerCardAcceptorId. Useful in narrowing down the results | 
**acquirerCardAcceptorId** | **String** | Acquirer Card Acceptor Id. Pre append ‘0’ if the data is not 15 digit. Note: Optional when any one of MerchantName or VisaMerchantId or VisaStoreId or BusinessRegistrationId or MerchantUrl is provided. | 
**merchantCountryCode** | **Integer** | Country Code of the registered Merchant.Merchant Country code is mandatory with MerchantName | 
**merchantPostalCode** | **String** | Postal Code of the registered Merchant | 
**visaStoreId** | **Double** | Unique identifier for a Branch/Outlet. Note: Optional when any one of MerchantName or VisaMerchantId or BusinessRegistrationId or MerchantUrl or AcquirerCardAcceptorId is provided. | 
**businessRegistrationId** | **String** | Merchants Business Registration ID/Tax ID.Note: Optional when any one of MerchantName or VisaMerchantId or VisaStoreId or MerchantUrl or AcquirerCardAcceptorId is provided. | 





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
