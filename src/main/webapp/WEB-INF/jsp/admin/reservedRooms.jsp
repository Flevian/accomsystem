<%--
  Created by IntelliJ IDEA.
  User: kanaiza
  Date: 10/31/16
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
  <div class="box-header with-border">
    <h3 class="box-title">ROOM RESERVATION MANAGEMENT</h3>
  </div><!-- /.box-header -->
  <div class="box-body">
    <div class="box">
      <div class="box-header">
           <c:if test="${message}">
          <div class="alert alert-success">
              ${content}
          </div>
        </c:if>
      </div>
      <div class="box-body">
        <div class="col-sm-7">
          <h3>Reserved rooms</h3>
          <div class="table-responsive">
            <c:choose>
              <c:when test="reserveRoomsList">
                <div class="alert alert-war">
                  No reserved rooms
                </div>
              </c:when>
              <c:otherwise>
                <table class="table table-striped table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Hostel name</th>
                    <th>Block#</th>
                    <th>Room #</th>
                    <th>Beneficiary</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="reserveRoomsList" var="reserve">
                    <tr>
                      <td>#</td>
                      <td>#</td>
                      <td>#</td>
                      <td>#</td>
                      <td>
                        <a href="/admin/student/#">Allocate</a>
                      </td>
                      <td>
                        <a href="/admin/student/#">Edit</a>
                      </td>
                    </tr>
                  </c:forEach>
                  <tr>
                    <div class="box-tools">
                      <jsp:include page="/WEB-INF/jsp/common/pagination.jsp">
                        <jsp:param name="paginatedRecord" value="#"/>
                        <jsp:param name="url" value="#"/>
                      </jsp:include>
                      <div class="input-group">
                        <form method="get" action="/admin/reserveRooms">
                          <input type="text" name="search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search reserved room"/>
                          <div class="input-group-btn">
                            <button class="btn btn-sm btn-default"><i class="fa fa-search">Go</i></button>
                          </div>
                        </form>
                      </div>
                    </div>
                  </tr>
                  </tbody>
                </table>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
