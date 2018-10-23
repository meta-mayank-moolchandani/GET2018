'use strict';

angular
    .module('product-list')
    .component('productList',{
            templateUrl:'all-product-list/product-list-template.html',
            controller:function productListController($http,$rootScope,$scope){
                let url = 'http://localhost:3000';
                $rootScope.totalItemsInCart;
                $rootScope.totalItemsInCart=0;
                
                $rootScope.localArrayOfCart;
                $rootScope.localArrayOfCart = [];

                
                var self = this;

                self.localProductList;


                $http.get(url+"/cart").then(function(response){
                    $rootScope.totalItemsInCart = response.data.length;
                    $rootScope.localArrayOfCart = response.data;
                
                });

               this.isProductExistInCart =  function (product){
                    let isProductExistFlag = false;
                    for(let index = 0; index<$rootScope.localArrayOfCart.length; index++){
                        if($rootScope.localArrayOfCart[index].productId===product.id){
                            isProductExistFlag = true;
                            break;
                        }
                    }

                    return isProductExistFlag;
                }

                this.addItemToLocalCart=function(product){
                    //debugger;
                   
                  //  console.log("add Item Called");


                    $rootScope.localArrayOfCart.push({
                        productId: product.id,
                        productQuantity: 1,
                        productPrice: product.price,
                        productName: product.name,
                        productImage: product.imgUrl,
                        
                    });

                    
                     for(let index = 0; index<self.localProductList.length;index++){
                         if(self.localProductList[index].id===product.id){
                             self.localProductList[index].isItemAddedToCart = true;
                             break;
                         }
                    }
                                           
                    $rootScope.totalItemsInCart+=1;
                            
                    $http({
                        method:'POST',
                        url:url+"/cart",
                        data:{
                            productId: product.id,
                            productQuantity: 1,
                            productPrice: product.price,
                            productName: product.name,
                            productImage: product.imgUrl
                        },
                        dataType:'json'
                    });

                    window.location.reload();
    
                }

                function changeQuantityInLocalCart(productId,operator){
                    for(let index = 0; index<$rootScope.localArrayOfCart.length; index++){
                        if($rootScope.localArrayOfCart[index].productId===productId){
                            if(operator==="+"){
                                $rootScope.localArrayOfCart[index].productQuantity+=1; 
                            }else{
                                if($rootScope.localArrayOfCart[index].productQuantity>1){
                                    $rootScope.localArrayOfCart[index].productQuantity-=1; 
                                }else{
                                    deleteProductFromLocalCart(productId);
                                }
                            }
                        }
                    }
                }

                function deleteProductFromLocalCart(productId){
                    for (var index = 0; index < $rootScope.localArrayOfCart.length; index++){
                        if ($rootScope.localArrayOfCart[index].productId===productId) { 
                            $rootScope.localArrayOfCart.splice(index, 1);
                            break;
                        }
                    }    
                }



                this.addItemsToCart = function(product){

                        
                            // $rootScope.totalItemsInCart+=1;
                            
                            // $http({
                            //     method:'POST',
                            //     url:url+"/cart",
                            //     data:{
                            //         productId: product.id,
                            //         productQuantity: 1,
                            //         productPrice: product.price,
                            //         productName: product.name,
                            //         productImage: product.imgUrl
                            //     },
                            //     dataType:'json'
                            // });
                          //  hello();
                        // }else{
                        //     $http({
                        //         method:'PUT',
                        //         url:url+"/cart/"+response.data[0].id,
                        //         data:{
                        //             id:response.data.id,
                        //             productId: product.id,
                        //             productQuantity: response.data[0].productQuantity+1,
                        //             productPrice: product.price,
                        //             productName: product.name,
                        //             productImage: product.imgUrl
                        //         },
                        //         dataType:'json'
                        //     });
                        // }
               

                };

                


               $http.get(url+'/all').then(function(response){
               
                    self.localProductList = response.data;
                    
                    for(let index = 0; index<self.localProductList.length; index++){
                        self.localProductList[index].isItemAddedToCart = false;
                        if(self.isProductExistInCart(self.localProductList[index])){
                            self.localProductList[index].isItemAddedToCart = true;
                        }
                    }
                });
                
        


            $scope.getProductQuantityFromCart = function(productId){
                let productQuantity = 0;
                for (var index = 0; index < $rootScope.localArrayOfCart.length; index++){
                    if($rootScope.localArrayOfCart[index].productId===productId){
                        productQuantity = $rootScope.localArrayOfCart[index].productQuantity;
                    }
                }
                return productQuantity;
            }



            this.changeQuantityInCart = function(productId,Operator){
                changeQuantityInLocalCart(productId,Operator);

                if(Operator==="+"){
                    $http.get(url+'/cart?productId='+productId).then(function(response){
                        
                        $http({
                            method:'PUT',
                            url:url+"/cart/"+response.data[0].id,
                            data:{
                                id:response.data[0].id,
                                productId: response.data[0].productId,
                                productQuantity: response.data[0].productQuantity+1,
                                productPrice: response.data[0].productPrice,
                                productName: response.data[0].productName,
                                productImage: response.data[0].productImage
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
                                    productQuantity: response.data[0].productQuantity-1,
                                    productPrice: response.data[0].productPrice,
                                    productName: response.data[0].productName,
                                    productImage: response.data[0].productImage
                                    
                                },
                                dataType:'json'
                            });

                        //    hello();
                        }else{
                            $http({
                                method:'DELETE',
                                url:url+"/cart/"+response.data[0].id,
                            })
                        }
                        
                    });
                }
              //  hello();           
            }
        }
 });