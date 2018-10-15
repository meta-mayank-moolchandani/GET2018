angular
    .module('userList')
    .component('userList',{
        templateUrl:'userList/user-template.html',
        controller:function userListController($scope,$http){
            var self = this;

            $http.get('http://localhost:3000/user').then(function(response){
                self.users = response.data;
            });

            

            $scope.addUser = function(){
                //alert(userData.id+ ": "+ userData.name);
                if($scope.selectedUserData.id==null || $scope.selectedUserData.id===undefined){
                    $http({
                        method: 'POST',
                        url: 'http://localhost:3000/user',
                        data: $scope.selectedUserData,
                        dataType:'json'
                    });
                }else{
                    $http({
                        method: 'PUT',
                        url: 'http://localhost:3000/user/'+ $scope.selectedUserData.id,
                        data: $scope.selectedUserData,
                        dataType:'json'
                    });
                }
                window.location.reload();
            }

            $scope.editUser = function(userId){
                $http.get('http://localhost:3000/user/'+ userId).then(function(response){
                    $scope.selectedUserData = response.data;
                });
            }


        }
    });