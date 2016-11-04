<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body class="skin-blue sidebar-mini">
<div class="wrapper">
 <header class="main-header">
    <!-- Logo -->
    <a href="/admin/" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>A</b>P</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Admin</b>Panel</span>
    </a>
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


                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Profile</a>
                            </div>
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

        /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li>
                <a href="/admin/home"><i class="fa fa-tachometer"></i> <span>Dashboard</span></a>
            </li>

            <li>
                <a href="/admin/zones"><i class="fa fa-files-o"></i> <span>Zones</span></a>
            </li>

            <li>
                <a href="/admin/hostels/list"><i class="fa fa-files-o"></i> <span>Hostels</span></a>
            </li>
            <li>
                <a href="#/admin/reservedRooms"><i class="fa fa-files-o"></i> <span>Reserved Rooms</span></a>
            </li>
            <li>
                <a href="/admin/hostels/roomitems"><i class="fa fa-files-o"></i> <span>Room Items</span></a>
            </li>
            <li>
                <a href="/admin/student/list"><i class="fa fa-files-o"></i> <span>Students</span></a>
            </li>
            <li>
                <a href="#/admin/reports"><i class="fa fa-files-o"></i> <span>Reports</span></a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <!-- Main content -->
    <section class="content">

