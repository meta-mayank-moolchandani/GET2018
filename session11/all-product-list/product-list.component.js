'use strict';




angular
    .module('product-list')
    .component('productList',{
            templateUrl:'all-product-list/product-list-template.html',
            controller:function productListController($scope,$http){
                let url = 'http://localhost:3000';

                var self = this;
                $http.get(url+'/all').then(function(response){
                    self.listOfProducts = response.data;
                });
            }
        });