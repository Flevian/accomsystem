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
    <h3 class="box-title">ROOM TRANSFER FORM</h3>
    <div class="box-tools">
      <div class="input-group">
        <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
        <div class="input-group-btn">
          <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
        </div>
      </div>
    </div>
  </div><!-- /.box-header -->
  <div class="box-body">
    <div class="box">
      <div class="box-header">
        <%--<div class="box-tools">
            <a type="button" class="btn btn-primary btn-sm" href="#">
                Users
            </a>
            &nbsp;&nbsp;
            <a type="button" class="btn btn-primary btn-sm" href="#">
                Roles
            </a>
        </div>--%>

        <c:if test="#">
          <div class="alert alert-success">
              #
          </div>
        </c:if>
      </div>
      <div class="box-body">
        <div class="row">
          <div class="col-sm-6 col-sm-offset-1">
            <div class="box-header">
              <p><h3> Student Profile</h3>
              </p>
              <p>
              <h4>NAME : ${profile.student.name}</h4>
              </p>
              <p>
              <h4>REG # : ${profile.studentRegNo}</h4>
              </p>
              <p>
              <h4>ROOM # : ${profile.student.bed.number} </h4>
              </p>

              <c:if test="#">
                <div class="alert alert-success">
                    #
                </div>
              </c:if>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-10">
            <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
              <%--<form:form acceptCharset="UTF-8" action="/admin/setRoomTranferForm" method="post" modelAttribute="roomTranfer" cssClass="form-horizontal" role="form">
              <div class="form-group">
                <label for="#" class="col-sm-3 control-label">Preferred room</label>
                <div class="col-sm-9">
                  <form:textarea path="#" cssClass="form-control" value="" readonly="true"/>
                  <form:errors path="#" cssClass="form-inline" />
                </div>
              </div>
              <div class="form-group">
                <label for="#" class="col-sm-3 control-label">Transfer reason</label>
                <div class="col-sm-9">
                  <form:textarea path="#" cssClass="form-control" value="" readonly="true"/>
                  <form:errors path="#" cssClass="form-inline" />
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-3 col-sm-10">
                  <input class="btn btn-success" type="submit" value="Accept">
                  <input class="btn btn-warning" type="submit" value="Reject">
                </div>
              </div>
            </form:form>--%>
          </div>
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
