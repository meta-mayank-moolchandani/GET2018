'use strict';

angular
    .module('product-list')
    .component('productList',{
            templateUrl:'all-product-list/product-list-template.html',
            controller:function productListController($http,$rootScope,$scope){
                let url = 'http://localhost:3000';
                $rootScope.totalItemsInCart;
                $rootScope.totalItemsInCart=0;
                
                var self = this;

                $http.get(url+"/cart").then(function(response){
                    $rootScope.totalItemsInCart = response.data.length;
                });

                this.addItemsToCart = function(product){
                    $http.get(url+'/cart?productId='+product.id).then(function(response){
                        if(response.data.length===0){
                            $rootScope.totalItemsInCart+=1;
                            $http({
                                method:'POST',
                                url:url+"/cart",
                                data:{
                                    productId: product.id,
                                    productQuantity: 1
                                },
                                dataType:'json'
                            });
                            hello();
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

                };

               function hello(){ $http.get(url+'/all').then(function(response){
                        self.listOfProducts = response.data;
                        for(let x = 0; x<self.listOfProducts.length; x++){
                            self.listOfProducts[x].isItemAddedToCart = false;
                            $http.get(url+"/cart?productId="+self.listOfProducts[x].id).then(function(response){
                                if(response.data.length===1){
                                    self.listOfProducts[x].isItemAddedToCart = true;
                                    
                                    self.listOfProducts[x].quantity = response.data[0].productQuantity;
                                }
                            });
                        }
                });

            }
        
            hello();
            
           

            this.changeQuantityInCart = function(productId,Operator){

                
                console.log("pid:"+productId);
                console.log(url+'/cart?productId='+productId);

                if(Operator==="+"){
                    
                    $http.get(url+'/cart?productId='+productId).then(function(response){
                        
                        $http({
                            method:'PUT',
                            url:url+"/cart/"+response.data[0].id,
                            data:{
                                id:response.data[0].id,
                                productId: response.data[0].productId,
                                productQuantity: response.data[0].productQuantity+1
                            },
                            dataType:'json'
                        });
                    });


                }else{
                    $http.get(url+'/cart?productId='+productId).then(function(response){
                        if(response.data[0].productQuantity>1){
                            $http({
                                method:'PUT',
                                url:url+"/cart/"+response.data[0].id,
                                data:{
                                    id:response.data[0].id,
                                    productId: response.data[0].productId,
                                    productQuantity: response.data[0].productQuantity-1
                                },
                                dataType:'json'
                            });

                            hello();
                        }else{
                            $http({
                                method:'DELETE',
                                url:url+"/cart/"+response.data[0].id,
                            })
                        }
                        
                    });
                }
                hello();           
            }
        }
 });