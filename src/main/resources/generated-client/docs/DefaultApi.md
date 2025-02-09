# DefaultApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiCustomersGet**](DefaultApi.md#apiCustomersGet) | **GET** /api/customers | Get all customers |
| [**apiCustomersIdDelete**](DefaultApi.md#apiCustomersIdDelete) | **DELETE** /api/customers/{id} | Delete a customer |
| [**apiCustomersIdGet**](DefaultApi.md#apiCustomersIdGet) | **GET** /api/customers/{id} | Get customer by ID |
| [**apiCustomersIdPut**](DefaultApi.md#apiCustomersIdPut) | **PUT** /api/customers/{id} | Update customer details |
| [**apiCustomersPost**](DefaultApi.md#apiCustomersPost) | **POST** /api/customers | Create a new customer |
| [**apiOrdersCustomerCustomerIdGet**](DefaultApi.md#apiOrdersCustomerCustomerIdGet) | **GET** /api/orders/customer/{customerId} | Get orders by customer ID |
| [**apiOrdersFilterOrderDateGet**](DefaultApi.md#apiOrdersFilterOrderDateGet) | **GET** /api/orders/filter/orderDate | Get orders by order date |
| [**apiOrdersFilterStatusGet**](DefaultApi.md#apiOrdersFilterStatusGet) | **GET** /api/orders/filter/status | Get orders by status |
| [**apiOrdersGet**](DefaultApi.md#apiOrdersGet) | **GET** /api/orders | Get all orders |
| [**apiOrdersIdDelete**](DefaultApi.md#apiOrdersIdDelete) | **DELETE** /api/orders/{id} | Delete an order |
| [**apiOrdersIdGet**](DefaultApi.md#apiOrdersIdGet) | **GET** /api/orders/{id} | Get order by ID |
| [**apiOrdersIdPut**](DefaultApi.md#apiOrdersIdPut) | **PUT** /api/orders/{id} | Update order details |
| [**apiOrdersPageGet**](DefaultApi.md#apiOrdersPageGet) | **GET** /api/orders/page | Get paginated orders |
| [**apiOrdersPost**](DefaultApi.md#apiOrdersPost) | **POST** /api/orders | Create a new order |


<a id="apiCustomersGet"></a>
# **apiCustomersGet**
> List&lt;Customer&gt; apiCustomersGet()

Get all customers

Retrieve a list of all customers

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<Customer> result = apiInstance.apiCustomersGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiCustomersGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Customer&gt;**](Customer.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of customers |  -  |

<a id="apiCustomersIdDelete"></a>
# **apiCustomersIdDelete**
> apiCustomersIdDelete(id)

Delete a customer

Delete a customer by their unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The customer ID
    try {
      apiInstance.apiCustomersIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiCustomersIdDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The customer ID | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Customer deleted successfully |  -  |
| **404** | Customer not found |  -  |

<a id="apiCustomersIdGet"></a>
# **apiCustomersIdGet**
> Customer apiCustomersIdGet(id)

Get customer by ID

Retrieve a customer by their unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The customer ID
    try {
      Customer result = apiInstance.apiCustomersIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiCustomersIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The customer ID | |

### Return type

[**Customer**](Customer.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A customer |  -  |
| **404** | Customer not found |  -  |

<a id="apiCustomersIdPut"></a>
# **apiCustomersIdPut**
> apiCustomersIdPut(id, customer)

Update customer details

Update an existing customer by their unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The customer ID
    Customer customer = new Customer(); // Customer | Customer details to update
    try {
      apiInstance.apiCustomersIdPut(id, customer);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiCustomersIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The customer ID | |
| **customer** | [**Customer**](Customer.md)| Customer details to update | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Customer updated successfully |  -  |
| **400** | Bad request |  -  |
| **404** | Customer not found |  -  |

<a id="apiCustomersPost"></a>
# **apiCustomersPost**
> apiCustomersPost(customer)

Create a new customer

Create a new customer in the system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Customer customer = new Customer(); // Customer | Customer to be created
    try {
      apiInstance.apiCustomersPost(customer);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiCustomersPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customer** | [**Customer**](Customer.md)| Customer to be created | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Customer created successfully |  -  |
| **400** | Bad request |  -  |

<a id="apiOrdersCustomerCustomerIdGet"></a>
# **apiOrdersCustomerCustomerIdGet**
> List&lt;Order&gt; apiOrdersCustomerCustomerIdGet(customerId, page, size)

Get orders by customer ID

Retrieve all orders placed by a specific customer

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID customerId = UUID.randomUUID(); // UUID | The customer ID
    Integer page = 0; // Integer | Page number
    Integer size = 10; // Integer | Page size
    try {
      List<Order> result = apiInstance.apiOrdersCustomerCustomerIdGet(customerId, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersCustomerCustomerIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **customerId** | **UUID**| The customer ID | |
| **page** | **Integer**| Page number | [optional] [default to 0] |
| **size** | **Integer**| Page size | [optional] [default to 10] |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of orders for the specified customer |  -  |

<a id="apiOrdersFilterOrderDateGet"></a>
# **apiOrdersFilterOrderDateGet**
> List&lt;Order&gt; apiOrdersFilterOrderDateGet(orderDate, page, size)

Get orders by order date

Retrieve orders filtered by the order date with pagination

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    LocalDate orderDate = LocalDate.now(); // LocalDate | The order date to filter by
    Integer page = 0; // Integer | Page number
    Integer size = 10; // Integer | Page size
    try {
      List<Order> result = apiInstance.apiOrdersFilterOrderDateGet(orderDate, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersFilterOrderDateGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **orderDate** | **LocalDate**| The order date to filter by | |
| **page** | **Integer**| Page number | [optional] [default to 0] |
| **size** | **Integer**| Page size | [optional] [default to 10] |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of orders filtered by order date |  -  |

<a id="apiOrdersFilterStatusGet"></a>
# **apiOrdersFilterStatusGet**
> List&lt;Order&gt; apiOrdersFilterStatusGet(status, page, size)

Get orders by status

Retrieve orders filtered by status with pagination

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String status = "status_example"; // String | The status to filter by
    Integer page = 0; // Integer | Page number
    Integer size = 10; // Integer | Page size
    try {
      List<Order> result = apiInstance.apiOrdersFilterStatusGet(status, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersFilterStatusGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **status** | **String**| The status to filter by | |
| **page** | **Integer**| Page number | [optional] [default to 0] |
| **size** | **Integer**| Page size | [optional] [default to 10] |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of orders filtered by status |  -  |

<a id="apiOrdersGet"></a>
# **apiOrdersGet**
> List&lt;Order&gt; apiOrdersGet()

Get all orders

Retrieve a list of all orders

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<Order> result = apiInstance.apiOrdersGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of orders |  -  |

<a id="apiOrdersIdDelete"></a>
# **apiOrdersIdDelete**
> apiOrdersIdDelete(id)

Delete an order

Delete an order by its unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order ID
    try {
      apiInstance.apiOrdersIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersIdDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The order ID | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order deleted successfully |  -  |
| **404** | Order not found |  -  |

<a id="apiOrdersIdGet"></a>
# **apiOrdersIdGet**
> Order apiOrdersIdGet(id)

Get order by ID

Retrieve an order by its unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order ID
    try {
      Order result = apiInstance.apiOrdersIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The order ID | |

### Return type

[**Order**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An order |  -  |
| **404** | Order not found |  -  |

<a id="apiOrdersIdPut"></a>
# **apiOrdersIdPut**
> apiOrdersIdPut(id, order)

Update order details

Update an existing order by its unique ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order ID
    Order order = new Order(); // Order | Order details to update
    try {
      apiInstance.apiOrdersIdPut(id, order);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **UUID**| The order ID | |
| **order** | [**Order**](Order.md)| Order details to update | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order updated successfully |  -  |
| **400** | Bad request |  -  |
| **404** | Order not found |  -  |

<a id="apiOrdersPageGet"></a>
# **apiOrdersPageGet**
> List&lt;Order&gt; apiOrdersPageGet(page, size)

Get paginated orders

Retrieve orders with pagination (without filters)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Integer page = 56; // Integer | Page number
    Integer size = 56; // Integer | Page size
    try {
      List<Order> result = apiInstance.apiOrdersPageGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersPageGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| Page number | |
| **size** | **Integer**| Page size | |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A paginated list of orders |  -  |

<a id="apiOrdersPost"></a>
# **apiOrdersPost**
> apiOrdersPost(order)

Create a new order

Create a new order in the system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Order order = new Order(); // Order | Order to be created
    try {
      apiInstance.apiOrdersPost(order);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#apiOrdersPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **order** | [**Order**](Order.md)| Order to be created | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Order created successfully |  -  |
| **400** | Bad request |  -  |

