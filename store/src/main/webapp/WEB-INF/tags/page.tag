<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ attribute name="styles" type="java.util.List" %>
<%@ attribute name="title" required="true" %>
<template:master title="${title}" styles="${styles}">
    <jsp:doBody/>
</template:master>
