# WebIsbnGeneratorApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nextIsbnUsingPOST**](WebIsbnGeneratorApi.md#nextIsbnUsingPOST) | **POST** /api/isbn | nextIsbn


<a name="nextIsbnUsingPOST"></a>
# **nextIsbnUsingPOST**
> String nextIsbnUsingPOST()

nextIsbn

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.WebIsbnGeneratorApi;


WebIsbnGeneratorApi apiInstance = new WebIsbnGeneratorApi();
try {
    String result = apiInstance.nextIsbnUsingPOST();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebIsbnGeneratorApi#nextIsbnUsingPOST");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

