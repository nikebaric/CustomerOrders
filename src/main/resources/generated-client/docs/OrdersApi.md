# OrdersApi

All URIs are relative to *http://localhost:8080/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createOrder**](OrdersApi.md#createOrder) | **POST** /orders | Create a new order |
| [**deleteOrder**](OrdersApi.md#deleteOrder) | **DELETE** /orders/{id} | Delete an order by ID |
| [**getAllOrders**](OrdersApi.md#getAllOrders) | **GET** /orders | Get all orders |
| [**getOrderById**](OrdersApi.md#getOrderById) | **GET** /orders/{id} | Get an order by ID |
| [**getOrdersByFilters**](OrdersApi.md#getOrdersByFilters) | **GET** /orders/filters | Get orders by filters (orderDate, status) |
| [**getOrdersPage**](OrdersApi.md#getOrdersPage) | **GET** /orders/page | Get orders with pagination |
| [**updateOrder**](OrdersApi.md#updateOrder) | **PUT** /orders/{id} | Update an order by ID |


<a id="createOrder"></a>
# **createOrder**
> String createOrder(order)

Create a new order

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    Order order = new Order(); // Order | 
    try {
      String result = apiInstance.createOrder(order);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#createOrder");
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
| **order** | [**Order**](Order.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order successfully created |  -  |

<a id="deleteOrder"></a>
# **deleteOrder**
> String deleteOrder(id)

Delete an order by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order's ID
    try {
      String result = apiInstance.deleteOrder(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#deleteOrder");
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
| **id** | **UUID**| The order&#39;s ID | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order successfully deleted |  -  |
| **404** | Order not found |  -  |

<a id="getAllOrders"></a>
# **getAllOrders**
> List&lt;Order&gt; getAllOrders()

Get all orders

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    try {
      List<Order> result = apiInstance.getAllOrders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#getAllOrders");
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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of all orders |  -  |

<a id="getOrderById"></a>
# **getOrderById**
> Order getOrderById(id)

Get an order by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order's ID
    try {
      Order result = apiInstance.getOrderById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#getOrderById");
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
| **id** | **UUID**| The order&#39;s ID | |

### Return type

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The order |  -  |
| **404** | Order not found |  -  |

<a id="getOrdersByFilters"></a>
# **getOrdersByFilters**
> List&lt;Order&gt; getOrdersByFilters(orderDate, status, page, size)

Get orders by filters (orderDate, status)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    String orderDate = "orderDate_example"; // String | Filter by order date (yyyy-MM-dd)
    String status = "NEW"; // String | Filter by order status
    Integer page = 0; // Integer | Page number (default: 0)
    Integer size = 10; // Integer | Number of items per page (default: 10)
    try {
      List<Order> result = apiInstance.getOrdersByFilters(orderDate, status, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#getOrdersByFilters");
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
| **orderDate** | **String**| Filter by order date (yyyy-MM-dd) | [optional] |
| **status** | **String**| Filter by order status | [optional] [enum: NEW, IN_PROGRESS, COMPLETED] |
| **page** | **Integer**| Page number (default: 0) | [optional] [default to 0] |
| **size** | **Integer**| Number of items per page (default: 10) | [optional] [default to 10] |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A filtered, paginated list of orders |  -  |

<a id="getOrdersPage"></a>
# **getOrdersPage**
> List&lt;Order&gt; getOrdersPage(page, size)

Get orders with pagination

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    Integer page = 0; // Integer | 
    Integer size = 10; // Integer | 
    try {
      List<Order> result = apiInstance.getOrdersPage(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#getOrdersPage");
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
| **page** | **Integer**|  | [optional] [default to 0] |
| **size** | **Integer**|  | [optional] [default to 10] |

### Return type

[**List&lt;Order&gt;**](Order.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A paginated list of orders |  -  |

<a id="updateOrder"></a>
# **updateOrder**
> String updateOrder(id, order)

Update an order by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/api");

    OrdersApi apiInstance = new OrdersApi(defaultClient);
    UUID id = UUID.randomUUID(); // UUID | The order's ID
    Order order = new Order(); // Order | 
    try {
      String result = apiInstance.updateOrder(id, order);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrdersApi#updateOrder");
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
| **id** | **UUID**| The order&#39;s ID | |
| **order** | [**Order**](Order.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Order successfully updated |  -  |
| **404** | Order not found |  -  |
| **400** | Invalid input or status transition error |  -  |

