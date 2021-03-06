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
        <h3 class="box-title">${block.name.toUpperCase()} BLOCK MANAGEMENT</h3>
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

                 <c:if test="${message}">
                    <div class="alert alert-success">
                            ${content}
                    </div>
                </c:if>
            </div>
            <div class="box-body">
                <div class="col-sm-8">
                            <h3>Rooms</h3>
                            <div class="table-responsive">
                                <c:choose>
                                    <c:when test="${empty roomsPage.content}">
                                        <div class="alert alert-war">
                                            No rooms registered
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                            <tr>
                                                <th>Room #</th>
                                                <th>Type</th>
                                                <th>Capacity</th>
                                                <th>Cost</th>
                                                <th>Beds</th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${roomsPage.content}" var="room">
                                                <tr>
                                                    <td>${room.name}</td>
                                                    <td>${room.roomType.name()}</td>
                                                    <td>${room.capacity}</td>
                                                    <td>${room.cost}</td>
                                                    <td>${room.beds.size()}</td>
                                                    <td>
                                                        <a href="/admin/room/view/${room.id}">View</a>
                                                    </td>
                                                    <td>
                                                        <a href="/admin/room/edit/${room.id}/${block.id}?flag=true">Edit</a>
                                                    </td>
                                                    <td>
                                                        <a href="/admin/room/edit/${room.id}/${block.id}?reserve=true">Reserve</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            <tr>
                                                <jsp:include page="/WEB-INF/jsp/common/pagination.jsp">
                                                    <jsp:param name="paginatedRecord" value="roomsPage"/>
                                                    <jsp:param name="url" value="${pagenatedUrl}"/>
                                                </jsp:include>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                </div>
                <div class="col-sm-4">
                    <div style="margin-top: 50px">
                        <div class="box-body">
                            <c:choose>
                                <c:when test="${flag == 'true'}">
                                    <h3>Edit Room</h3>
                                    <form:form acceptCharset="UTF-8" action="/admin/room/updateroom" method="post" modelAttribute="selectedRoom" cssClass="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="name" class="col-sm-3 control-label">Number</label>
                                            <div class="col-sm-9">
                                                <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="Room number" />
                                                <form:input path="id" id="id" type="hidden"/>
                                                <form:input path="blockId" id="blockId" value="${block.id}" type="hidden"/>
                                                <form:errors path="name" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="roomType" class="col-sm-3 control-label">Room type</label>
                                            <div class="col-sm-9">
                                                <form:select path="roomType" id="roomType" type="select" cssClass="form-control">
                                                    <form:options/>
                                                </form:select>
                                                <form:errors path="roomType" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="cost" class="col-sm-3 control-label">Cost</label>
                                            <div class="col-sm-9">
                                                <form:input path="cost" id="name" type="text" cssClass="form-control" placeholder="Cost (KSH)" />
                                                <form:errors path="cost" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="capacity" class="col-sm-3 control-label">Capacity</label>
                                            <div class="col-sm-9">
                                                <form:select path="capacity" id="capacity" type="select" cssClass="form-control">
                                                    <form:option value="1">1</form:option>
                                                    <form:option value="2">2</form:option>
                                                    <form:option value="3">3</form:option>
                                                    <form:option value="4">4</form:option>
                                                </form:select>
                                                <form:errors path="capacity" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-10">
                                                <input class="btn btn-success" type="submit" value="Submit">
                                            </div>
                                        </div>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${reserve == 'true'}">
                                            <h3>Reserve Room</h3>
                                            <form:form acceptCharset="UTF-8" action="/admin/room/reserveroom" method="post" modelAttribute="reserveRooms" cssClass="form-horizontal" role="form">
                                                <div class="form-group">
                                                    <label for="reserveId" class="col-sm-3 control-label">Number</label>
                                                    <div class="col-sm-9">
                                                        <form:input path="reserveId" id="reserveId" type="text" cssClass="form-control" readonly="true"/>
                                                        <form:input path="roomId" id="roomId" type="hidden"/>
                                                        <form:input path="blockId" id="blockId" value="${block.id}" type="hidden"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="reserveRoomStatus" class="col-sm-3 control-label">Reserved for</label>
                                                    <div class="col-sm-9">
                                                        <form:select path="reserveRoomStatus" id="reserveRoomStatus" type="select" cssClass="form-control">
                                                            <form:options/>
                                                        </form:select>
                                                        <form:errors path="reserveRoomStatus" cssClass="form-inline" />
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-offset-3 col-sm-10">
                                                        <input class="btn btn-success" type="submit" value="Submit">
                                                    </div>
                                                </div>
                                            </form:form>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
                                                ADD ROOM
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--modal--%>
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Register Room</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box">
                            <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
                                <form:form acceptCharset="UTF-8" action="/admin/room/createroom" method="post" modelAttribute="room" cssClass="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-3 control-label">Number</label>
                                        <div class="col-sm-9">
                                            <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="Room number" />
                                            <form:input path="id" id="id" type="hidden"/>
                                            <form:input path="blockId" id="blockId" value="${block.id}" type="hidden"/>
                                            <form:errors path="name" cssClass="form-inline" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="roomType" class="col-sm-3 control-label">Room type</label>
                                        <div class="col-sm-9">
                                            <form:select path="roomType" id="roomType" type="select" cssClass="form-control">
                                                <form:options/>
                                            </form:select>
                                            <form:errors path="roomType" cssClass="form-inline" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="cost" class="col-sm-3 control-label">Cost</label>
                                        <div class="col-sm-9">
                                            <form:input path="cost" id="name" type="text" cssClass="form-control" placeholder="Cost (KSH)" />
                                            <form:errors path="cost" cssClass="form-inline" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="capacity" class="col-sm-3 control-label">Capacity</label>
                                        <div class="col-sm-9">
                                            <form:select path="capacity" id="capacity" type="select" cssClass="form-control">
                                                <form:option value="1">1</form:option>
                                                <form:option value="2">2</form:option>
                                                <form:option value="3">3</form:option>
                                                <form:option value="4">4</form:option>
                                            </form:select>
                                            <form:errors path="capacity" cssClass="form-inline" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-10">
                                            <input class="btn btn-success" type="submit" value="Submit">
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
    </div>
</div>
<%--end body--%>
<!-- start of footer section -->

<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
