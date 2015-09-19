<html>
<head>
<script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<script src="js/myController.js"></script>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>

<div ng-app="myApp" ng-controller="myController">

<form name="myForm" novalidate>

    <p>EmployeeId</p>
    <input type="text" name="employeeId" ng-model="employees[0].employeeId" required/>
    <span style="color:red" ng-show="myForm.employeeId.$dirty && myForm.employeeId.$invalid">
        <span ng-show="myForm.employeeId.$error.required">Employee Id is required</span>
    </span>
    <p>Employee Name</p>
    <input type="text" name="employeeName" ng-model="employees[0].name" required/>
        <span style="color:red" ng-show="myForm.employeeName.$dirty && myForm.employeeName.$invalid">
            <span ng-show="myForm.employeeName.$error.required">Employee name is required</span>
        </span>
    <p>Employee Email</p>
        <input type="email" name="employeeEmail" ng-model="employees[0].email" required/>
            <span style="color:red" ng-show="myForm.employeeEmail.$dirty && myForm.employeeEmail.$invalid">
                <span ng-show="myForm.employeeEmail.$error.required">Employee email is required</span>
                <span ng-show="myForm.employeeEmail.$error.email">Invalid email address</span>
            </span>
</form>


Charges: {{getCharges()|currency:'&euro;'}}<br>
<ul>
    <li ng-repeat="name in names | filter:test | orderBy:'country'">
        {{name.name +"," + name.country}}
    </li>
</ul>

<table>
    <tr>
        <th>EmployeeId</th>
        <th>Name</th>
        <th>Email</th>
        <th>Designation</th>
        <th>City</th>
        <th>Blog</th>
    </tr>
    <tr ng-repeat="employee in employees | orderBy:'employeeId'">
        <td>{{employee.employeeId}}</td>
        <td>{{employee.name}}</td>
        <td>{{employee.email}}</td>
        <td>{{employee.designation}}</td>
        <td>{{employee.city}}</td>
        <td>{{employee.blogUrl}}</td>
    </tr>
</table>

<!--
 ng-disabled
 <input type="checkbox" ng-model="mySwitch">
 ng-init="hour=13" ng-show="hour > 12"
 ng-click="count = count + 1"
 -->

</div>
</body>
</html>