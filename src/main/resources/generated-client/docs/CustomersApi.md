# CustomersApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomer**](CustomersApi.md#createCustomer) | **POST** /customers | Create a new customer |
| [**deleteCustomerById**](CustomersApi.md#deleteCustomerById) | **DELETE** /customers/{customerId} | Delete a customer by ID |
| [**getCustomerById**](CustomersApi.md#getCustomerById) | **GET** /customers/{customerId} | Get a customer by ID |
| [**getCustomers**](CustomersApi.md#getCustomers) | **GET** /customers | Get all customers |
| [**updateCustomerById**](CustomersApi.md#updateCustomerById) | **PUT** /customers/{customerId} | Update a customer by ID |


<a id="createCustomer"></a>
# **createCustomer**
> Customer createCustomer(customer)

Create a new customer

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CustomersApi apiInstance = new CustomersApi(defaultClient);
    Customer customer = new Customer(); // Customer | The customer to be created
    try {
      Customer result = apiInstance.createCustomer(customer);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomersApi#createCustomer");
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
| **customer** | [**Customer**](Customer.md)| The customer to be created | [optional] |

### Return type

[**Customer**](Customer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Customer created successfully |  -  |

<a id="deleteCustomerById"></a>
# **deleteCustomerById**
> deleteCustomerById(customerId)

Delete a customer by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CustomersApi apiInstance = new CustomersApi(defaultClient);
    UUID customerId = UUID.randomUUID(); // UUID | The ID of the customer
    try {
      apiInstance.deleteCustomerById(customerId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomersApi#deleteCustomerById");
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
| **customerId** | **UUID**| The ID of the customer | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Customer deleted successfully |  -  |
| **404** | Customer not found |  -  |

<a id="getCustomerById"></a>
# **getCustomerById**
> Customer getCustomerById(customerId)

Get a customer by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CustomersApi apiInstance = new CustomersApi(defaultClient);
    UUID customerId = UUID.randomUUID(); // UUID | The ID of the customer
    try {
      Customer result = apiInstance.getCustomerById(customerId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomersApi#getCustomerById");
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
| **customerId** | **UUID**| The ID of the customer | |

### Return type

[**Customer**](Customer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Customer details |  -  |
| **404** | Customer not found |  -  |

<a id="getCustomers"></a>
# **getCustomers**
> List&lt;Customer&gt; getCustomers()

Get all customers

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CustomersApi apiInstance = new CustomersApi(defaultClient);
    try {
      List<Customer> result = apiInstance.getCustomers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomersApi#getCustomers");
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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of customers |  -  |

<a id="updateCustomerById"></a>
# **updateCustomerById**
> Customer updateCustomerById(customerId, customer)

Update a customer by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CustomersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CustomersApi apiInstance = new CustomersApi(defaultClient);
    UUID customerId = UUID.randomUUID(); // UUID | The ID of the customer
    Customer customer = new Customer(); // Customer | The updated customer details
    try {
      Customer result = apiInstance.updateCustomerById(customerId, customer);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomersApi#updateCustomerById");
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
| **customerId** | **UUID**| The ID of the customer | |
| **customer** | [**Customer**](Customer.md)| The updated customer details | [optional] |

### Return type

[**Customer**](Customer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Customer updated successfully |  -  |
| **404** | Customer not found |  -  |

