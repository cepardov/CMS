<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title><g:layoutTitle default="PIR Programa Informática Rural"/></title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <asset:stylesheet src="pir-conf-0.1.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <g:layoutHead/>
</head>

<body class="grey lighten-2">
<header>
    <!--
    <nav class="z-depth-4 blue-grey lighten-1">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="sass.html">Sass</a></li>
                <li><a href="badges.html">Components</a></li>
                <li><a href="collapsible.html">JavaScript</a></li>
            </ul>
        </div>
    </nav>
    -->


    <ul id="slide-out" class="sidenav sidenav-fixed blue-grey darken-2">
        <div class="user-view z-depth-3">
            <div class="background">
                <asset:image src="it.jpg"/>
            </div>
            <div class=" logoc center">
                <a href="${createLink(uri:'/')}"><asset:image class="logo" src="pir-logo-v2.png"/></a>
            </div>
        </div>
        <li><a class="white-text" href="${createLink(uri:'/')}">Programa Informática Rural</a></li>
        <li><g:link class="white-text" controller="news" action="index">Noticias PIR</g:link></li>
        <li><g:link class="white-text" controller="user" action="index">Usuarios</g:link></li>
    </ul>
    <!--
    <a href="#" data-target="slide-out" class="sidenav-trigger hide-on-med-and-up"><i class="material-icons">menu</i></a>
    -->
    <g:layoutBody/>
</header>

<g:if test="${controllerName != "news" && controllerName != "user"}">
    <footer class="page-footer blue-grey darken-2">
        <!--
        <div class="container">
            <div class="row">
                <div class="col l6 s12">
                    <h5 class="white-text">Footer Content</h5>
                    <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                </div>
                <div class="col l4 offset-l2 s12">
                    <h5 class="white-text">Links</h5>
                    <ul>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                        <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                    </ul>
                </div>
            </div>
        </div>
        -->
        <div class="footer-copyright">
            <div class="container">
                © 2018 Copyright Programa Informática Rural
                <span class="grey-text right">V0.2.2018 - <a class="grey-text" href="#!">@cepardov</a></span>
            </div>
        </div>
    </footer>
</g:if>

<asset:javascript src="pir-jquery-3.3.1.min.js"/>
<asset:javascript src="materialize.min.js"/>
<asset:javascript src="pir-conf-v0.1.js"/>

<g:if test="${flash.message}">
    <script>
        window.onload=function(){M.toast({html: '${flash.message}'});}
    </script>
</g:if>
<!-- Generic Modals -->
<g:if test="${actionName == 'index'}">
    <g:if test="${params.id}">
        <script>
            $(document).ready(function(){
                $('#modalEdicion').modal('open');
            });
        </script>
    </g:if>
</g:if>
</body>
</html>