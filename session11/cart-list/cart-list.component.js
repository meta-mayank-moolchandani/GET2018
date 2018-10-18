'use strict';

angular.module('cartList').
    component('cartList',{
        templateUrl: 'cart-list/cart-list.template.html',
        controller: function CartListController($scope,$http,$rootScope,$window){

            Array.prototype.clear = function() {
                while (this.length) {
                  this.pop();
                }
              };

            console.log("----------In the Cart-----------");
            var self= this;
            $rootScope.cartItems = 0 ;
            $rootScope.cartArray = [];
            $scope.totalAmount = 0;

            $scope.printContent = function (){
                console.log("---------------------");
                for(let i=0;i<$rootScope.cartArray.length;i++)
                {
                    console.log($rootScope.cartArray[i].id +" "+ $rootScope.cartArray[i].name +" "+$rootScope.cartArray[i].quantity);
                }
                console.log("---------------------");
            }

            $scope.printContent();

            $http.get('http://localhost:3000/cartItems').then(function(response){
                $scope.cartItemList = response.data;
                let cart=0;
                let itemAdded = 0;
                for(;cart<$scope.cartItemList.length;cart++){
                     $rootScope.cartArray[cart] = $scope.cartItemList[cart];
                     itemAdded = itemAdded + $rootScope.cartArray[cart].quantity;
                   }
                $rootScope.cartItems = itemAdded;
                self.itemInTheCart = $rootScope.cartArray;
                $scope.getTotalAmount();
            });


            $http.get('http://localhost:3000/products').then(function(response){
                $scope.products = response.data;
            });

             $scope.getTotalAmount = function(){
                    $scope.totalAmount = 0;
                    let cart=0;
                    let itemAdded = 0;
                    for(;cart<$rootScope.cartArray.length;cart++){
                            $scope.totalAmount = $scope.totalAmount + $rootScope.cartArray[cart].quantity * $rootScope.cartArray[cart].price ;
                          }
                    console.log("Total amount : "+$scope.totalAmount);
            }
            
            $scope.findProductQuantityInCart = function(id){
                let itemProduct;
                let cart=0;
                for(;cart<$rootScope.cartArray.length;cart++){
                    if($rootScope.cartArray[cart].id==id)
                        {
                            itemProduct=$rootScope.cartArray[cart].quantity;
                        }
                }
                return itemProduct;
            }
            
            $scope.decreaseItemQuantity = function (product){
            let cart=0;
            for(;cart<$rootScope.cartArray.length;cart++)
            {
                if($rootScope.cartArray[cart].id==product.id)
                    {
                        if($rootScope.cartArray[cart].quantity > 0)
                        {
                            $rootScope.cartItems = $rootScope.cartItems - 1;
                            $rootScope.cartArray[cart].quantity--;
                            $rootScope.cartArray[cart].total=$rootScope.cartArray[cart].quantity*$rootScope.cartArray[cart].price;
                            $http.put('http://localhost:3000/cartItems/'+product.id,$rootScope.cartArray[cart]);
                        }
                        if($rootScope.cartArray[cart].quantity <= 0)
                        {
                            $rootScope.cartArray[cart].quantity = 0;
                            $rootScope.cartArray.splice(cart, 1);
                            product.itemAdded = "false";
                            $http.put('http://localhost:3000/products/'+product.id,product);
                            $http.delete('http://localhost:3000/cartItems/'+product.id); 
                        }
                        if($rootScope.cartItems < 1)
                        {
                            $rootScope.cartItems = 0;
                        }
                        break;
                    }
            }
            $scope.printContent();
            $scope.getTotalAmount();
            }
            
            $scope.increaseItemQuantity = function (product){
            let cart=0;
            for(;cart<$rootScope.cartArray.length;cart++)
            {
                if($rootScope.cartArray[cart].id==product.id)
                    {
                        $rootScope.cartItems = $rootScope.cartItems + 1;
                        $rootScope.cartArray[cart].quantity++;
                        $rootScope.cartArray[cart].total=$rootScope.cartArray[cart].quantity*$rootScope.cartArray[cart].price;
                        $http.put('http://localhost:3000/cartItems/'+product.id,$rootScope.cartArray[cart]);
                        break;
                    }
            }
            $scope.printContent();
            $scope.getTotalAmount();
            }
           

            $scope.clearTheCart = function(){
                for(let i=0;i<$rootScope.cartArray.length;i++){
                    let product;
                    for(let j=0;j<$scope.products.length;j++){
                        if($rootScope.cartArray[i].id==$scope.products[j].id)
                            {
                                product = $scope.products[j] ;
                                break;
                            }
                    }
                    product.itemAdded = "false";
                    $http.put('http://localhost:3000/products/'+product.id,product);
                    $http.delete('http://localhost:3000/cartItems/'+product.id);
                    console.log("Deleting : "+product.name);
                }
                for(let i=0;i<$rootScope.cartArray.length;i++){
                    $rootScope.cartArray[i].quantity = 0;
                }
                $rootScope.cartArray.clear();
                $rootScope.cartItems = 0;
                $scope.totalAmount = 0;
             }
        }
    });
