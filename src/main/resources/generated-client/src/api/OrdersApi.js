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
import Order from '../model/Order';

/**
* Orders service.
* @module api/OrdersApi
* @version 1.0.0
*/
export default class OrdersApi {

    /**
    * Constructs a new OrdersApi. 
    * @alias module:api/OrdersApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }


    /**
     * Callback function to receive the result of the createOrder operation.
     * @callback module:api/OrdersApi~createOrderCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Order} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Create a new order
     * @param {Object} opts Optional parameters
     * @param {module:model/Order} [order] The order to be created
     * @param {module:api/OrdersApi~createOrderCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Order}
     */
    createOrder(opts, callback) {
      opts = opts || {};
      let postBody = opts['order'];

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
      let returnType = Order;
      return this.apiClient.callApi(
        '/orders', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the deleteOrderById operation.
     * @callback module:api/OrdersApi~deleteOrderByIdCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Delete an order by ID
     * @param {String} orderId The ID of the order
     * @param {module:api/OrdersApi~deleteOrderByIdCallback} callback The callback function, accepting three arguments: error, data, response
     */
    deleteOrderById(orderId, callback) {
      let postBody = null;
      // verify the required parameter 'orderId' is set
      if (orderId === undefined || orderId === null) {
        throw new Error("Missing the required parameter 'orderId' when calling deleteOrderById");
      }

      let pathParams = {
        'orderId': orderId
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
        '/orders/{orderId}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the getOrderById operation.
     * @callback module:api/OrdersApi~getOrderByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Order} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get an order by ID
     * @param {String} orderId The ID of the order
     * @param {module:api/OrdersApi~getOrderByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Order}
     */
    getOrderById(orderId, callback) {
      let postBody = null;
      // verify the required parameter 'orderId' is set
      if (orderId === undefined || orderId === null) {
        throw new Error("Missing the required parameter 'orderId' when calling getOrderById");
      }

      let pathParams = {
        'orderId': orderId
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
      let returnType = Order;
      return this.apiClient.callApi(
        '/orders/{orderId}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the getOrders operation.
     * @callback module:api/OrdersApi~getOrdersCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/Order>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Get all orders
     * @param {module:api/OrdersApi~getOrdersCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<module:model/Order>}
     */
    getOrders(callback) {
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
      let returnType = [Order];
      return this.apiClient.callApi(
        '/orders', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }

    /**
     * Callback function to receive the result of the updateOrderById operation.
     * @callback module:api/OrdersApi~updateOrderByIdCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Order} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Update an order by ID
     * @param {String} orderId The ID of the order
     * @param {Object} opts Optional parameters
     * @param {module:model/Order} [order] The updated order details
     * @param {module:api/OrdersApi~updateOrderByIdCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Order}
     */
    updateOrderById(orderId, opts, callback) {
      opts = opts || {};
      let postBody = opts['order'];
      // verify the required parameter 'orderId' is set
      if (orderId === undefined || orderId === null) {
        throw new Error("Missing the required parameter 'orderId' when calling updateOrderById");
      }

      let pathParams = {
        'orderId': orderId
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
      let returnType = Order;
      return this.apiClient.callApi(
        '/orders/{orderId}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, null, callback
      );
    }


}
