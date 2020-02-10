# StoreWebServiceApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStockUsingGET**](StoreWebServiceApi.md#getStockUsingGET) | **GET** /api/store/{category}/{item} | getStock
[**setStockUsingPOST**](StoreWebServiceApi.md#setStockUsingPOST) | **POST** /api/store/{category}/{item} | setStock


<a name="getStockUsingGET"></a>
# **getStockUsingGET**
> String getStockUsingGET(category, item)

getStock

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StoreWebServiceApi;


StoreWebServiceApi apiInstance = new StoreWebServiceApi();
String category = "category_example"; // String | category
String item = "item_example"; // String | item
try {
    String result = apiInstance.getStockUsingGET(category, item);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreWebServiceApi#getStockUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |
 **item** | **String**| item |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="setStockUsingPOST"></a>
# **setStockUsingPOST**
> setStockUsingPOST(category, item, stock)

setStock

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StoreWebServiceApi;


StoreWebServiceApi apiInstance = new StoreWebServiceApi();
String category = "category_example"; // String | category
String item = "item_example"; // String | item
Integer stock = 56; // Integer | stock
try {
    apiInstance.setStockUsingPOST(category, item, stock);
} catch (ApiException e) {
    System.err.println("Exception when calling StoreWebServiceApi#setStockUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**| category |
 **item** | **String**| item |
 **stock** | **Integer**| stock |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

