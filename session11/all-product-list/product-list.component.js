'use strict';

angular
    .module('product-list')
    .component('productList',{
            templateUrl:'all-product-list/product-list-template.html',
            controller:function productListController($http,$rootScope){
                let url = 'http://localhost:3000';
                $rootScope.totalItemsInCart;
                
                var self = this;

                $http.get(url+"/cart").then(function(response){
                    $rootScope.totalItemsInCart = response.data.length;
                });

                $http.get(url+"/cart?productId="+productId).then(function(response){
                    self.isItemAdded = response.data.length;
                });


                this.addItemsToCart = function(product){
                    $http.get(url+'/cart?productId='+product.id).then(function(response){
                        if(response.data.length===0){
                            $http({
                                method:'POST',
                                url:url+"/cart",
                                data:{
                                    productId: product.id,
                                    productQuantity: 1
                                },
                                dataType:'json'
                            });
                        }else{
                            $http({
                                method:'PUT',
                                url:url+"/cart/"+response.data[0].id,
                                data:{
                                    id:response.data.id,
                                    productId: product.id,
                                    productQuantity: response.data[0].productQuantity+1
                                },
                                dataType:'json'
                            });
                        }
                   });
                    window.location.reload();
                };



                console.log("pc"+ $rootScope.totalItemsInCart);


                var self = this;
                $http.get(url+'/all').then(function(response){
                    self.listOfProducts = response.data;
                });
            }
        });