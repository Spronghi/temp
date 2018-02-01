angular
    .module('app.services')
    .factory('dataService', ['$http', '$cookies', '$cookieStore', dataService]);
             
function dataService($http, $cookies, $cookieStore) {
    function set(data) {
      $cookieStore.put('operator', data);
      $cookieStore.put('operatorId', data.id);
    }
    function getCurrentId() {
      return $cookieStore.get('operatorId');
    }
    function getCurrentOperator() {
      return $cookieStore.get('operator');
    }
    function unset(){
        $cookieStore.put('operatorId', 0);
        $cookieStore.put('operator', 0);
    }
    return {
      set: set,
      unset: unset,
      getCurrentOperator: getCurrentOperator,
      getCurrentId: getCurrentId
    }
}