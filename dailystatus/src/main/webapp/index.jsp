<html>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>

<body>

<div ng-app="myApp" ng-controller="myController">
Charges: {{getCharges()|currency:'&euro;'}}<br>
<input type = "text" ng-model='test'/><br>
<ul>
    <li ng-repeat="name in names | filter:test | orderBy:'country'">
        {{name.name +"," + name.country}}
    </li>
</ul>

Status : ${status/get}
</div>
<script src="/js/myController.js"></script>
</body>
</html>