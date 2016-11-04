<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
        <jsp:param name="title" value="EU"/>
    </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/studentHead.jsp"/>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
    <div class="box-header with-border">
        <h3 class="box-title">
            <sec:authorize access="isAuthenticated()">
                <sec:authentication property="principal" var="principal"/>
                <span class="hidden-xs">MY PROFILE</span>
            </sec:authorize>
        </h3>

        <div class="box-tools">
            <div class="input-group">
                <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;"
                       placeholder="Search"/>

                <div class="input-group-btn">
                    <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                </div>
            </div>
        </div>
    </div>

<%--Modal--%>
    <!-- /.box-header -->
    <div class="box-body no-padding">
        <div class="row">
            <div class="box">
                <div class="col-sm-12">
                <div class="box">
                    <div class="box-header">
                        <c:if test="${message}">
                            <div class="alert alert-success">
                                    ${content}
                            </div>
                        </c:if>
                    </div>
                    <div class="box-body">
                        <sec:authorize access="isAuthenticated()">
                            <sec:authentication property="principal" var="principal"/>
                    <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
                        <form:form acceptCharset="UTF-8" action="/student/nonResident/${profile.id}" method="post" modelAttribute="nonResident" cssClass="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="landLordFullName" class="col-sm-3 control-label">Landlord full name</label>
                                <div class="col-sm-9">
                                    <form:input path="landLordFullName" id="landLordFullName" type="text" cssClass="form-control" placeholder="Landlord name" />
                                    <form:errors path="landLordFullName" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="landLordPhoneNumber" class="col-sm-3 control-label">Lanlord contact</label>
                                <div class="col-sm-9">
                                    <form:input path="landLordPhoneNumber" id="landLordPhoneNumber" type="text" cssClass="form-control" placeholder="contact(e.g 0706665474)" />
                                    <form:errors path="landLordPhoneNumber" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="hostelName" class="col-sm-3 control-label">Hostel name</label>
                                <div class="col-sm-9">
                                    <form:input path="hostelName" id="hostelName" type="text" cssClass="form-control" placeholder="hostel(e.g Essy estate)" />
                                    <form:errors path="hostelName" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="location" class="col-sm-3 control-label">Location</label>
                                <div class="col-sm-9">
                                    <form:input path="location" id="location" type="text" cssClass="form-control" placeholder="Locatio(e.g Njokerio)" />
                                    <form:errors path="location" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="semCount" class="col-sm-3 control-label">Semester</label>
                                <div class="col-sm-9">
                                    <form:select path="semCount" name="semCount" type="select" cssClass="form-control">
                                        <form:options />
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-10">
                                    <input class="btn btn-success" type="submit" value="Submit">
                                </div>
                            </div>
                        </form:form>

                    </sec:authorize>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
