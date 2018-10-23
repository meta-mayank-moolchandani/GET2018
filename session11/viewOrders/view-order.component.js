'use strict'

angular
    .module('view-orders')
    .component('viewOrders',{
        templateUrl:'/viewOrders/view-order-template.html',
        controller:function orderViewController($http){
            var self = this;
            let url = 'http://localhost:3000/';

            $http.get(url + "orderDetails").then(function(response){
                self.orders = response.data;

            });

        }
    });
