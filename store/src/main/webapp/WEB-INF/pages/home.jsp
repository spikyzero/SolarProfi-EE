<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<template:page title="${title}">
    <div id="content">
        <div id="title">
            <h1><spring:message code="message.welcome"/></h1>
            <h3><spring:message code="message.glad.see"/></h3>
            <a href="<c:url value="/"/>">Home</a>
        </div>
        <div>
            <a href=?locale=en>UK</a>
            <a href=?locale=uk>UA</a>
            <a href=?locale=de>DE</a>
        </div>
    </div>
</template:page>
