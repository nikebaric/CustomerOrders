/**
 * CustomerOrders API
 * API for managing customers and orders.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 *
 */


import ApiClient from "../ApiClient";
import Customer from '../model/Customer';

/**
* Customers service.
* @module api/CustomersApi
* @version 1.0.0
*/
export default class CustomersApi {

    /**
    * Constructs a new CustomersApi. 
    * @alias module:api/CustomersApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }


    /**
     * Callback function to receive the result of the createCustomer operation.
     * @callback module:api/CustomersApi~createCustomerCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Customer} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Create a new customer
     * @param {Object} opts Optional parameters
     * @param {module:model/Customer} [customer] The customer to be created
     * @param {module:api/CustomersApi~createCustomerCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Customer}
     */
    createCustomer(opts, callback) {
      opts = opts || {};
      let postBody = opts['customer'];

      let pathParams = {
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json'];
      let accepts = ['application/json'];
      let returnType = Customer;
      return this.apiClient.callApi(
        '/customers', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the deleteCustomerById operation.
     * @callback module:api/CustomersApi~deleteCustomerByIdCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Delete a customer by ID
     * @param {String} customerId The ID of the customer
     * @param {module:api/CustomersApi~deleteCustomerByIdCallback} callback The callback function, accepting three arguments: error, data, response
     */
    deleteCustomerById(customerId, callback) {
      let postBody = null;
      // verify the required parameter 'customerId' is set
      if (customerId === undefined || customerId === null) {
        throw new Error("Missing the required parameter 'customerId' when calling deleteCustomerById");
      }

      let pathParams = {
        'customerId': customerId
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = [];
      let returnType = null;
      return this.apiClient.callApi(
        '/customers/{customerId}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the getCustomerById operation.
     * @callback module:api/CustomersApi~getCustomerByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Customer} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get a customer by ID
     * @param {String} customerId The ID of the customer
     * @param {module:api/CustomersApi~getCustomerByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Customer}
     */
    getCustomerById(customerId, callback) {
      let postBody = null;
      // verify the required parameter 'customerId' is set
      if (customerId === undefined || customerId === null) {
        throw new Error("Missing the required parameter 'customerId' when calling getCustomerById");
      }

      let pathParams = {
        'customerId': customerId
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = Customer;
      return this.apiClient.callApi(
        '/customers/{customerId}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the getCustomers operation.
     * @callback module:api/CustomersApi~getCustomersCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/Customer>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get all customers
     * @param {module:api/CustomersApi~getCustomersCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<module:model/Customer>}
     */
    getCustomers(callback) {
      let postBody = null;

      let pathParams = {
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = [Customer];
      return this.apiClient.callApi(
        '/customers', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the updateCustomerById operation.
     * @callback module:api/CustomersApi~updateCustomerByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Customer} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Update a customer by ID
     * @param {String} customerId The ID of the customer
     * @param {Object} opts Optional parameters
     * @param {module:model/Customer} [customer] The updated customer details
     * @param {module:api/CustomersApi~updateCustomerByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Customer}
     */
    updateCustomerById(customerId, opts, callback) {
      opts = opts || {};
      let postBody = opts['customer'];
      // verify the required parameter 'customerId' is set
      if (customerId === undefined || customerId === null) {
        throw new Error("Missing the required parameter 'customerId' when calling updateCustomerById");
      }

      let pathParams = {
        'customerId': customerId
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json'];
      let accepts = ['application/json'];
      let returnType = Customer;
      return this.apiClient.callApi(
        '/customers/{customerId}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }


}
