<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Modul client</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Managment hotel</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>Buna, ${name}</li>
                <li><a href="#">Log Out</a></li>
                <li><a href="#">Help</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" ><a href="./Prezentare_camere.jsp">Prezentare camere</a></li>
                <!--  <li ><a href="./Rezervare_camere.html">Rezervare camera</a></li> -->
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Modul client</h1>
            <h2 class="sub-header">Prezentare camere</h2>

            <div class="input-group">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Criteriu cautare <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Pret</a></li>
                        <li><a href="#">Paturi</a></li>
                        <li><a href="#">Tv</a></li>
                        <li><a href="#">Wi-fi</a></li>
                        <li><a href="#">Frigider</a></li>
                        <li><a href="#">Telefon</a></li>
                        <li><a href="#">Baie</a></li>
                        <li><a href="#">Piscina</a></li>
                        <li><a href="#">Balcon</a></li>
                    </ul>
                </div><!-- /btn-group -->
                <input type="text" class="form-control" placeholder="Search for...">
            </div><!-- /input-group -->
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Pret</th>
                        <th>Paturi</th>
                        <th>TV</th>
                        <th>Wi-fi</th>
                        <th>Frigider</th>
                        <th>Telefon</th>
                        <th>Baie</th>
                        <th>Piscina</th>
                        <th>Balcon</th>
                        <th>Rezervare</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link rel="stylesheet" href="http://getbootstrap.com/examples/dashboard/dashboard.css" >

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="../main.css" >

</body>
</html>
