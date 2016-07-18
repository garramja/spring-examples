function RecipeController($scope, $http) {

    $http.get('http://localhost:8090/recipes').
        success(function(data) {
            $scope.recipes = data;
        });

    $scope.getById = function(id) {
        $http.get('http://localhost:8090/recipes/' + id)
            .then(function(response) {
                $scope.recipe = response.data;
                $("#add").hide();
                $("#edit").show();
                $("#id").attr("disabled","disabled");
            });
    }

    $scope.add = function(recipe) {
        $http.post('http://localhost:8090/recipes', recipe)
            .success(function () {
                callback();
            });
    }

    $scope.edit = function(recipe) {
        $http.put('http://localhost:8090/recipes/' + recipe.id, recipe)
            .success(function () {
                callback();
                $("#add").show();
                $("#edit").hide();
                $("#id").removeAttr("disabled");
                $("#reset").click();
            });
    }

    $scope.delete = function(id) {
        $http.delete('http://localhost:8090/recipes/' + id)
            .success(function () {
                callback();
            });
    }

    function callback() {
        $http.get('http://localhost:8090/recipes').
            success(function(data) {
                $scope.recipes = data;
            });
    }

}