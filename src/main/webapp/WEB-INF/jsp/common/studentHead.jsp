<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body class="skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal" var="principal"/>
            <a href="/student/profile/${principal.user.id}" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>S</b>P</span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>Student</b>Portal</span>
            </a>
        </sec:authorize>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">

                        <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/resources/images/default.png" class="user-image" alt="User image">
                            <sec:authorize access="isAuthenticated()">
                                <sec:authentication property="principal" var="principal"/>
                                <span class="hidden-xs">${principal.user.loginId}</span>
                            </sec:authorize>

                        </a>
                        <ul class="dropdown-menu">

                            <!-- Menu Body -->
                            <li class="user-body">

                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">

                                <div class="pull-right">
                                    <a href="/users/logout" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">


            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal" var="principal"/>
                    <li>
                        <a href="/student/profile/${principal.user.id}"><i class="fa fa-tachometer"></i> <span>Profile</span></a>
                    </li>

                    <li>
                        <a href="/student/hostels"><i class="fa fa-files-o"></i> <span>Booking</span></a>
                    </li>

                    <li>
                        <a href="/student/room/details/${principal.user.id}"><i class="fa fa-files-o"></i> <span>My room</span></a>
                    </li>

                    <li>
                        <a href="/student/room/transfer/${principal.user.id}"><i class="fa fa-files-o"></i> <span>Room Transfer</span></a>
                    </li>

                    <li>
                        <a href="#/student/non-resident/${principal.user.id}"><i class="fa fa-files-o"></i> <span>Non Resident form</span></a>
                    </li>
                </sec:authorize>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">




