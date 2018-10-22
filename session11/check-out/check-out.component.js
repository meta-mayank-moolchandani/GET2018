'use strict'

angular
    .module('check-out')
    .component('checkOut',{
        templateUrl:'./check-out/check-out-template.html',
        controller: function checkOutController($http){
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
            


            this.placeOrder = function(){
                let date = new Date();
                $http({
                   method:'POST',
                   url:url+"/orderDetails",
                   data:{
                       "Name":self.shipping.name,
                       "date": date,
                       "address1": self.shipping.address1,
                       "address2":self.shipping.address2,
                       "city":self.shipping.city,
                       "order":self.cartItems
                   },
                   dataType:'json'
               });

               for(let index  = 1; index<=self.totalItems; index++){
                    $http({
                        method:'DELETE',
                        url: url+'/cart/'+index
                    });
                }
            }
        }
    });