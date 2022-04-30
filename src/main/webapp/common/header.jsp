<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.util.List, com.jal.wholesales.model.*, com.jal.wholesales.web.controller.*"%>

<%
	String CONTEXT = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>WholeSales</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="<%=CONTEXT%>/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="<%=CONTEXT%>/css/style.css" type="text/css">


<!-- Css 2 Styles -->



<!-- Js principal -->

<script src="<%=CONTEXT%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=CONTEXT%>/js/bootstrap.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery-ui.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery.countdown.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery.nice-select.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery.zoom.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery.dd.min.js"></script>
<script src="<%=CONTEXT%>/js/jquery.slicknav.js"></script>
<script src="<%=CONTEXT%>/js/owl.carousel.min.js"></script>
<script src="<%=CONTEXT%>/js/main.js"></script>





</head>
<body>
	<%@include file="/common/header-top.jsp"%>
	<%@include file="/common/navigation-menu.jsp"%>