appCedula.controller("cedulaController", function($scope, $http){
	
	$scope.cedulas=[];
	$scope.cedula={};
	
	$scope.troco=[];
	
	$scope.sacar = {};
	$scope.sacar = "{ 10 : 5 }";

	$http({method:'POST', url:'http://localhost:8080/sacar',data:$scope.sacar})
	.then(function (response){
		console.log(response.data);
	} , function (response){
		console.log(response.data);
		console.log(response.status);
		
	});

		
		function appendTransform(defaults, transform) {

			  // We can't guarantee that the default transformation is an array
			  defaults = angular.isArray(defaults) ? defaults : [defaults];

			  // Append the new transformation to the defaults
			  return defaults.concat(transform);
			}
	
	
	
	/*$http({
	    method: 'POST',
	    url: 'http://localhost:8080/calcular',
	    data:{"valorSaque": 120,"moedas": [100,50,10]}
	}).then(function successCallback(response) {
	    console.log(response.data);
	    // this callback will be called asynchronously
	    // when the response is available
	    }, function errorCallback(response) {
	        console.log(response.data);
	    // called asynchronously if an error occurs
	    // or server returns response with an error status.
	});*/

	//$scope.carregarTroco();
	
	carregar= function (){
		$http({method:'GET', url:'http://localhost:8080/cedulas'})
		.then(function (response){
			$scope.cedulas=response.data;
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});
	};
	
	$scope.salvar= function (){
		
		//if ($scope.frmCedula.$valid){
			$http({method:'POST', url:'http://localhost:8080/cedulas',data:$scope.cedula})
			.then(function (response){
				//$scope.cedulas.push(response.data) ;
				carregar();
				$scope.cancelar();
				//$scope.frmCedula.$setPristine(true);
				
				
			} , function (response){
				console.log(response.data);
				console.log(response.status);
				
			});
		
		//}else {
		//	window.alert("Dados inválidos!");
		//}
	}
	
	$scope.excluir=function(cedula){
		$http({method:'DELETE', url:'http://localhost:8080/cedulas/'+cedula.id})
		.then(function (response){
			
			pos = $scope.cedulas.indexOf(cedula);
			$scope.cedulas.splice(pos , 1);
			
		} , function (response){
			console.log(response.data);
			console.log(response.status);
			
		});	
		
	};
	
	
	$scope.alterar= function (cli){
		$scope.cedula = angular.copy(cli);
	};
	
	
	$scope.cancelar=function (){
		$scope.cedula={};
	};
	
	carregar();	
	

	
});