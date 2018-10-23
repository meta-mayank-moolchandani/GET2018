'use strict';

angular.module('cartList').
    component('cartList',{
        templateUrl: 'cart-list/cart-list.template.html',
        controller: function CartListController($scope,$http,$rootScope,$window){

            var self = this;
            let url = 'http://localhost:3000';


            $http.get(url+"/cart").then(function(response){
                self.cartItems = response.data;
                self.totalItems = response.data.length;
            });

            this.totalPrice =0;
            
            this.getTotalPrice = function(){
                let totalPrice = 0;

                for(let index = 0 ; index < self.totalItems; index++){
                    totalPrice+= (self.cartItems[index].productPrice) * (self.cartItems[index].productQuantity);
                }
                return totalPrice;
            }

        }

  
    });
