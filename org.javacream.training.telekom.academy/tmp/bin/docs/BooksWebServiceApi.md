# BooksWebServiceApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteBookByIsbnUsingDELETE**](BooksWebServiceApi.md#deleteBookByIsbnUsingDELETE) | **DELETE** /api/books/{isbn} | deleteBookByIsbn
[**findBookByIsbnUsingGET**](BooksWebServiceApi.md#findBookByIsbnUsingGET) | **GET** /api/books/{isbn} | findBookByIsbn
[**newBookUsingPOST**](BooksWebServiceApi.md#newBookUsingPOST) | **POST** /api/books/{title} | newBook
[**updateBookUsingPUT**](BooksWebServiceApi.md#updateBookUsingPUT) | **PUT** /api/books/{isbn} | updateBook


<a name="deleteBookByIsbnUsingDELETE"></a>
# **deleteBookByIsbnUsingDELETE**
> deleteBookByIsbnUsingDELETE(isbn)

deleteBookByIsbn

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BooksWebServiceApi;


BooksWebServiceApi apiInstance = new BooksWebServiceApi();
String isbn = "isbn_example"; // String | isbn
try {
    apiInstance.deleteBookByIsbnUsingDELETE(isbn);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksWebServiceApi#deleteBookByIsbnUsingDELETE");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **isbn** | **String**| isbn |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="findBookByIsbnUsingGET"></a>
# **findBookByIsbnUsingGET**
> Book findBookByIsbnUsingGET(isbn)

findBookByIsbn

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BooksWebServiceApi;


BooksWebServiceApi apiInstance = new BooksWebServiceApi();
String isbn = "isbn_example"; // String | isbn
try {
    Book result = apiInstance.findBookByIsbnUsingGET(isbn);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksWebServiceApi#findBookByIsbnUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **isbn** | **String**| isbn |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="newBookUsingPOST"></a>
# **newBookUsingPOST**
> String newBookUsingPOST(title, price)

newBook

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BooksWebServiceApi;


BooksWebServiceApi apiInstance = new BooksWebServiceApi();
String title = "title_example"; // String | title
Double price = 3.4D; // Double | price
try {
    String result = apiInstance.newBookUsingPOST(title, price);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksWebServiceApi#newBookUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **title** | **String**| title |
 **price** | **Double**| price | [optional] [default to 9.99]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="updateBookUsingPUT"></a>
# **updateBookUsingPUT**
> Book updateBookUsingPUT(isbn, toUpdate)

updateBook

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BooksWebServiceApi;


BooksWebServiceApi apiInstance = new BooksWebServiceApi();
String isbn = "isbn_example"; // String | isbn
Book toUpdate = new Book(); // Book | toUpdate
try {
    Book result = apiInstance.updateBookUsingPUT(isbn, toUpdate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksWebServiceApi#updateBookUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **isbn** | **String**| isbn |
 **toUpdate** | [**Book**](Book.md)| toUpdate |

### Return type

[**Book**](Book.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

